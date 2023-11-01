package com.apiUsuarios.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apiUsuarios.domain.Usuario;
import com.apiUsuarios.dto.UsuarioDTO;
import com.apiUsuarios.exception.PasswordException;
import com.apiUsuarios.exception.UserNotFoundException;
import com.apiUsuarios.mapper.UsuarioMapper;
import com.apiUsuarios.repository.UsuarioRepository;
import com.apiUsuarios.util.ConstanteUtil;

@Service
public class UsuarioService {

    private UsuarioMapper usuarioMapper;
    private UsuarioRepository usuarioRepository;

    @Autowired
    protected UsuarioService(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
    }

    public Page<UsuarioDTO> listarUsuarios(Pageable pageable) {
        return this.usuarioRepository.findAll(pageable).map(this.usuarioMapper::converterEntidadeParaDTO);
    }

    @Transactional
    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        validarSenhas(usuarioDTO);
        var usuario = this.usuarioMapper.converterDTOParaEntidade(usuarioDTO);
        return this.usuarioMapper.converterEntidadeParaDTO(usuarioRepository.save(usuario));
    }

    @Transactional
    public void editarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente = this.findUserById(id);

        validarSenhas(usuarioDTO);

        usuarioExistente.setNome(usuarioDTO.getNome());
        usuarioExistente.setEmail(usuarioDTO.getEmail());
        usuarioExistente.setSenha(usuarioDTO.getSenha());

        usuarioRepository.save(usuarioExistente);
    }


    @Transactional
    public void excluirUsuario(Long id) {
        Usuario usuarioExistente = this.findUserById(id);
        usuarioRepository.deleteById(usuarioExistente.getId());
    }

    private Usuario findUserById(Long id) throws UserNotFoundException {
        return this.usuarioRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format(ConstanteUtil.MENSAGEM_USUARIO_INEXISTENTE, id)));
    }

    private void validarSenhas(UsuarioDTO usuarioDTO) {
        if (!usuarioDTO.getSenha().equals(usuarioDTO.getConfirmarSenha())) {
            throw new PasswordException(ConstanteUtil.MENSAGEM_SENHA_ERRO);
        }

    }
}

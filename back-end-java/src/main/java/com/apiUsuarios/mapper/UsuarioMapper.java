package com.apiUsuarios.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apiUsuarios.domain.Usuario;
import com.apiUsuarios.dto.UsuarioDTO;

@Component
public class UsuarioMapper {

    private final ModelMapper modelMapper;

    @Autowired
    protected UsuarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Usuario converterDTOParaEntidade(UsuarioDTO usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
    }

    public UsuarioDTO converterEntidadeParaDTO(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }
}

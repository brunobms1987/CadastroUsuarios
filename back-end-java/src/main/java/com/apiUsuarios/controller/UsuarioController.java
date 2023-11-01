package com.apiUsuarios.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apiUsuarios.dto.UsuarioDTO;
import com.apiUsuarios.dto.error.MensagemErro;
import com.apiUsuarios.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    protected UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Listar usuários.", responses = @ApiResponse(responseCode = "200", description = "SUCESSO"))
    public ResponseEntity<Page<UsuarioDTO>> listarUsuarios(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(this.usuarioService.listarUsuarios(pageable));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Inserir usuário.", responses = {
            @ApiResponse(responseCode = "201", description = "Usuário inserido com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MensagemErro.class)))
    })
    public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody @Valid UsuarioDTO usuario) {
        return new ResponseEntity<>(this.usuarioService.salvarUsuario(usuario), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualizar Usuário", responses = {
            @ApiResponse(responseCode = "204", description = "Usuário atualizado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida.",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MensagemErro.class))),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado.")
    })
    public ResponseEntity<Void> editarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioDTO usuario) {
        this.usuarioService.editarUsuario(id, usuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Deletar Usuário", responses = {
            @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public void excluirUsuario(@PathVariable @NotNull Long id) {
        this.usuarioService.excluirUsuario(id);
    }
}

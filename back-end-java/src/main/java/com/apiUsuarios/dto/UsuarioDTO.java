package com.apiUsuarios.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class UsuarioDTO {

    @Schema(description = "ID Usuário", example = "1")
    private Long id;

    @NotNull(message = "Favor inserir um nome válido (não permitido campo vazio).")
    @Size(min = 3, max = 80, message = "Favor inserir um nome entre 3 e 80 caracteres.")
    @Schema(description = "Nome Usuário", example = "Bruno Martins dos Santos")
    private String nome;

    @NotNull(message = "Favor inserir um e-mail válido (não permitido campo vazio).")
    @Pattern(regexp = "[A-Za-z0-9+_.-]+@(.+)$", message = "Formato do e-mail inválido, favor informar um e-mail válido.")
    @Size(min = 3, max = 80, message = "Favor inserir um e-mail entre 3 e 80 caracteres.")
    @Schema(description = "E-mail Usuário", example = "bruno@martins.com")
    private String email;

    @NotNull(message = "Favor inserir uma senha válida (não permitido campo vazio).")
    @Size(min = 8, max = 70, message = "Favor inserir um nome entre 8 e 70 caracteres.")
    @Schema(description = "Senha Usuário", example = "a1b2c3d4")
    private String senha;

    @NotNull(message = "Favor inserir uma senha válida (não permitido campo vazio).")
    @Size(min = 8, max = 70, message = "Favor inserir um nome entre 8 e 70 caracteres.")
    @Schema(description = "Confirmar Senha Usuário", example = "a1b2c3d4")
    private String confirmarSenha;

}

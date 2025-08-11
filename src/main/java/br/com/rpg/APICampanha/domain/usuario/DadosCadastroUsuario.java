package br.com.rpg.APICampanha.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank
        String login,

        @NotBlank
        String senha
) {
}

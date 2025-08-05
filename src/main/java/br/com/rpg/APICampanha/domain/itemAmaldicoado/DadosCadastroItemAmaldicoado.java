package br.com.rpg.APICampanha.domain.itemAmaldicoado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroItemAmaldicoado(
        @NotBlank
        String nome,
        @NotNull
        Elemento elemento,
        @NotBlank
        String descricao,
        boolean unico,
        boolean penalidadeCustomizada,
        String descricaoPenalidadeCustomizada
) {
}

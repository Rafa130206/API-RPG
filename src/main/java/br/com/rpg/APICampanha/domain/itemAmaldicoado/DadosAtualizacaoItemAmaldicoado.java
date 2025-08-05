package br.com.rpg.APICampanha.domain.itemAmaldicoado;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoItemAmaldicoado(
        @NotNull
        Long id,
        String nome,
        Elemento elemento,
        String descricao,
        Boolean unico,
        Boolean penalidadeCustomizada,
        String descricaoPenalidadeCustomizada
) {
}

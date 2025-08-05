package br.com.rpg.APICampanha.domain.itemAmaldicoado;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoItemAmaldicoado(
        @NotNull
        Long id,
        String nome,
        Elemento elemento,
        String descricao,
        boolean unico,
        boolean penalidadeCustomizada,
        String descricaoPenaloidadeCustomizada
) {
}

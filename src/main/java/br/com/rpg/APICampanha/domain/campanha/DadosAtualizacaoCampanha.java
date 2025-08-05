package br.com.rpg.APICampanha.domain.campanha;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoCampanha(
        @NotNull
        Long id,
        String titulo,
        String descricao
) {
}

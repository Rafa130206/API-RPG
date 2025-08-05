package br.com.rpg.APICampanha.domain.personagem;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosAtualizacaoPersonagem(
        @NotNull
        Long id,
        String nome,
        int vidaAtual,
        int vidaMaxima,
        int pontosDeEsforcoAtuais,
        int pontosDeEsforcoMaximos,
        int sanidadeAtual,
        int sanidadeMaxima,
        int qtdMunicao,
        String observacoes,
        Long campanhaId,
        List<Long> itensAmaldicoadosIds) {
}

package br.com.rpg.APICampanha.domain.personagem;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosAtualizacaoPersonagem(
        @NotNull
        Long id,
        String nome,
        Integer vidaAtual,
        Integer vidaMaxima,
        Integer pontosDeEsforcoAtuais,
        Integer pontosDeEsforcoMaximos,
        Integer sanidadeAtual,
        Integer sanidadeMaxima,
        Integer qtdMunicao,
        String observacoes,
        Long campanhaId,
        List<Long> itensAmaldicoadosIds) {
}

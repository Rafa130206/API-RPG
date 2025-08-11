package br.com.rpg.APICampanha.domain.personagem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record DadosCadastroPersonagem(
        @NotBlank
        String nome,

        @NotBlank
        Classe classe,

        @NotNull
        int vidaAtual,

        @NotNull
        int vidaMaxima,

        @NotNull
        int pontosDeEsforcoAtuais,

        @NotNull
        int pontosDeEsforcoMaximos,

        @NotNull
        int sanidadeAtual,

        @NotNull
        int sanidadeMaxima,

        @NotNull
        int qtdMunicao,

        @Size(max = 1000)
        String observacoes,

        @NotNull
        Long campanhaId,

        List<Long> itensAmaldicoadosIds
) {
}

package br.com.rpg.APICampanha.domain.personagem;

import br.com.rpg.APICampanha.domain.campanha.Campanha;
import br.com.rpg.APICampanha.domain.itemAmaldicoado.ItemAmaldicoado;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record DadosCadastroPersonagem(
        @NotBlank
        String nome,

        @NotBlank
        String classe,

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

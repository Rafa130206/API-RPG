package br.com.rpg.APICampanha.domain.personagem;

import br.com.rpg.APICampanha.domain.campanha.Campanha;
import br.com.rpg.APICampanha.domain.itemAmaldicoado.ItemAmaldicoado;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

        @NotBlank
        String observacoes,

        @NotNull @Valid
        Campanha campanha,

        List<ItemAmaldicoado> itensAmaldicoados
) {
}

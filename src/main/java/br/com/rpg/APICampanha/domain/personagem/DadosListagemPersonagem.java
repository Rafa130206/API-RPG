package br.com.rpg.APICampanha.domain.personagem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record DadosListagemPersonagem(Long id,
                                      String nome,
                                      Classe classe,
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

    public DadosListagemPersonagem(Personagem personagem) {
        this(personagem.getId(), personagem.getNome(), personagem.getClasse(), personagem.getVidaAtual(), personagem.getVidaMaxima(), personagem.getPontosDeEsforcoAtuais(), personagem.getPontosDeEsforcoMaximos(), personagem.getSanidadeAtual(), personagem.getSanidadeMaxima(), personagem.getQtdMunicao(), personagem.getObservacoes(), personagem.getCampanha().getId(), personagem.getItensAmaldicoados().stream().map(item -> item.getId()).toList());
    }
}

package br.com.rpg.APICampanha.domain.personagem;

import br.com.rpg.APICampanha.domain.campanha.Campanha;
import br.com.rpg.APICampanha.domain.itemAmaldicoado.ItemAmaldicoado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "personagens")
@Entity(name = "Personagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Classe classe;
    private int vidaAtual;
    private int vidaMaxima;
    private int pontosDeEsforcoAtuais;
    private int pontosDeEsforcoMaximos;
    private int sanidadeAtual;
    private int sanidadeMaxima;
    private int qtdMunicao;
    private String observacoes;

    @ManyToOne
    private Campanha campanha;

    @ManyToMany
    @JoinTable(
            name = "personagem_item",
            joinColumns = @JoinColumn(name = "personagem_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemAmaldicoado> itensAmaldicoados = new ArrayList<>();

    private boolean ativo;

    public Personagem(DadosCadastroPersonagem dados) {
        this.ativo = true;
        this.nome = dados.nome();
        classe = dados.classe();
        this.vidaAtual = dados.vidaAtual();
        this.vidaMaxima = dados.vidaMaxima();
        this.pontosDeEsforcoAtuais = dados.pontosDeEsforcoAtuais();
        this.pontosDeEsforcoMaximos = dados.pontosDeEsforcoMaximos();
        this.sanidadeAtual = dados.sanidadeAtual();
        this.sanidadeMaxima = dados.sanidadeMaxima();
        this.qtdMunicao = dados.qtdMunicao();
        this.observacoes = dados.observacoes();
    }

    public void atualizarInformacoes(DadosAtualizacaoPersonagem dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.vidaAtual() > -1) {
            this.vidaAtual = dados.vidaAtual();
        }

        if (dados.pontosDeEsforcoAtuais() > -1) {
            this.pontosDeEsforcoAtuais = dados.pontosDeEsforcoAtuais();
        }

        if (dados.pontosDeEsforcoMaximos() > -1) {
            this.pontosDeEsforcoMaximos = dados.pontosDeEsforcoMaximos();
        }

        if (dados.sanidadeAtual() > -1) {
            this.sanidadeAtual = dados.sanidadeAtual();
        }

        if (dados.sanidadeMaxima() > -1) {
            this.sanidadeMaxima = dados.sanidadeMaxima();
        }

        if (dados.vidaMaxima() > -1) {
            this.vidaMaxima = dados.vidaMaxima();
        }

        if (dados.qtdMunicao() > -1) {
            this.qtdMunicao = dados.qtdMunicao();
        }

        if (dados.observacoes() != null) {
            this.observacoes = dados.observacoes();
        }

    }

    public void adicionarItemAmaldicoado(ItemAmaldicoado item) {
        if (!this.itensAmaldicoados.contains(item)) {
            this.itensAmaldicoados.add(item);
        }
    }

    public void removerItemAmaldicoado(ItemAmaldicoado item) {
        this.itensAmaldicoados.remove(item);
    }

    public void excluir() { this.ativo = false; }

}

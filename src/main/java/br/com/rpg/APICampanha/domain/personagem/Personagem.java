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
    private String classe;
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
}

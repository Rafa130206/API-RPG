package br.com.rpg.APICampanha.domain.itemAmaldicoado;

import br.com.rpg.APICampanha.domain.personagem.Personagem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "itens_amaldicoados")
@Entity(name = "ItemAmaldicoado")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemAmaldicoado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Elemento elemento;

    @Column(length = 1000)
    private String descricao;
    private Boolean unico;
    private Boolean penalidadeCustomizada;

    @Column(length = 1000)
    private String descricaoPenalidadeCustomizada;

    @ManyToMany(mappedBy = "itensAmaldicoados")
    private List<Personagem> personagens = new ArrayList<>();

    private Boolean ativo;

    public ItemAmaldicoado(DadosCadastroItemAmaldicoado dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.elemento = dados.elemento();
        this.descricao = dados.descricao();
        this.unico = dados.unico();
        this.penalidadeCustomizada = dados.unico();
        this.descricaoPenalidadeCustomizada = dados.descricaoPenalidadeCustomizada();
    }

    public void atualizarInformacoes(DadosAtualizacaoItemAmaldicoado dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.elemento() != null) {
            this.elemento = dados.elemento();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.unico() != null) {
            this.unico = dados.unico();
        }
        if (dados.penalidadeCustomizada() != null) {
            this.penalidadeCustomizada = dados.penalidadeCustomizada();
        }
        if (dados.descricaoPenalidadeCustomizada() != null) {
            this.descricaoPenalidadeCustomizada = dados.descricaoPenalidadeCustomizada();
        }
    }

    public void excluir() { this.ativo = false; }
}

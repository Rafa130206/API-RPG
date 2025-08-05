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
    private boolean unico;
    private boolean penalidadeCustomizada;

    @Column(length = 1000)
    private String descricaoPenalidadeCustomizada;

    @ManyToMany(mappedBy = "itensAmaldicoados")
    private List<Personagem> personagens = new ArrayList<>();

    private boolean ativo;
}

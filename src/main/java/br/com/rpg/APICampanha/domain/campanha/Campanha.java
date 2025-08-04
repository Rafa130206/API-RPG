package br.com.rpg.APICampanha.domain.campanha;

import br.com.rpg.APICampanha.domain.personagem.Personagem;
import br.com.rpg.APICampanha.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "campanhas")
@Entity(name = "Campanha")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Campanha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate dataCriacao;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "campanha", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Personagem> personagens = new ArrayList<>();

    @PrePersist
    public void prePersist(){
        this.dataCriacao = LocalDate.now();
    }

    private boolean ativo;
}

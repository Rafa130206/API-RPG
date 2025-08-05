package br.com.rpg.APICampanha.domain.personagem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    Page<Personagem> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select p.ativo
            from Personagem p
            where
            p.id = :id
            """)
    boolean findAtivoById(Long idPersonagem);
}

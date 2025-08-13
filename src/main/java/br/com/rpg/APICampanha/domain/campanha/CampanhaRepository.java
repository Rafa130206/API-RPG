package br.com.rpg.APICampanha.domain.campanha;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CampanhaRepository extends JpaRepository<Campanha, Long> {
    Page<Campanha> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select c.ativo
            from Campanha c
            where
            c.id = :id
            """)
    boolean findAtivoById(Long idCampanha);

    Page<Campanha> findAllByUsuarioIdAndAtivoTrue(Long usuarioId, Pageable paginacao);
}

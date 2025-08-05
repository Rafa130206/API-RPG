package br.com.rpg.APICampanha.domain.itemAmaldicoado;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemAmaldicoadoRepository extends JpaRepository<ItemAmaldicoado, Long> {
    Page<ItemAmaldicoado> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select i.ativo
            from ItemAmaldicoado i
            where
            i.id = :id
            """)
    boolean findAtivoById(Long idItemAmaldicoado);
}

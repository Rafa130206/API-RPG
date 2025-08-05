package br.com.rpg.APICampanha.domain.campanha;

import java.time.LocalDate;
import java.util.List;

public record DadosListagemCampanha(Long id, String titulo, String descricao, LocalDate dataCriacao) {
        public DadosListagemCampanha(Campanha campanha) {
            this(campanha.getId(), campanha.getTitulo(), campanha.getDescricao(), campanha.getDataCriacao());
        }
}

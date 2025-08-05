package br.com.rpg.APICampanha.domain.campanha;

import jakarta.validation.constraints.NotBlank;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record DadosCadastroCampanha(
        @NotBlank
        String titulo,
        String descricao
) {
}

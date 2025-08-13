package br.com.rpg.APICampanha.controller;

import br.com.rpg.APICampanha.domain.campanha.*;
import br.com.rpg.APICampanha.domain.usuario.Usuario;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
@RequestMapping("/campanhas")
@SecurityRequirement(name = "bearer-key")
public class CampanhaController {

    @Autowired
    private CampanhaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemCampanha> cadastrar(@RequestBody @Valid DadosCadastroCampanha dados) {
        var usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var campanha = new Campanha(dados, usuario);
        repository.save(campanha);
        return ResponseEntity.created(URI.create("/campanhas/" + campanha.getId()))
                .body(new DadosListagemCampanha(campanha));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCampanha>> listar(@PageableDefault(size = 5) Pageable paginacao) {
        var usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var page = repository.findAllByUsuarioIdAndAtivoTrue(usuario.getId(), paginacao)
                .map(DadosListagemCampanha::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemCampanha> detalhar(@PathVariable Long id) {
        var campanha = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Campanha não encontrada"));
        return ResponseEntity.ok(new DadosListagemCampanha(campanha));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemCampanha> atualizar(@RequestBody @Valid DadosAtualizacaoCampanha dados) {
        var campanha = repository.findById(dados.id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Campanha não encontrada"));

        campanha.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemCampanha(campanha));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        var campanha = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Campanha não encontrada"));

        campanha.excluir();
        return ResponseEntity.noContent().build();
    }
}

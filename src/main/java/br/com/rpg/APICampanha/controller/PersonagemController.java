package br.com.rpg.APICampanha.controller;

import br.com.rpg.APICampanha.domain.campanha.Campanha;
import br.com.rpg.APICampanha.domain.campanha.CampanhaRepository;
import br.com.rpg.APICampanha.domain.personagem.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
@RequestMapping("/personagens")
@SecurityRequirement(name = "bearer-key")
public class PersonagemController {

    @Autowired
    private PersonagemRepository repository;

    @Autowired
    private CampanhaRepository campanhaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemPersonagem> cadastrar (@RequestBody @Valid DadosCadastroPersonagem dados) {
        Campanha campanha = campanhaRepository.findById(dados.campanhaId())
                .orElseThrow(() -> new EntityNotFoundException("Campanha não encontrada"));

        var personagem = new Personagem(dados);
        personagem.setCampanha(campanha);

        repository.save(personagem);
        return ResponseEntity
                .created(URI.create("/personagens/" + personagem.getId()))
                .body(new DadosListagemPersonagem(personagem));
    }


    @GetMapping
    public ResponseEntity<Page<DadosListagemPersonagem>> listar(@PageableDefault(size = 5, sort = "nome") Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPersonagem::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemPersonagem> detalhar (@PathVariable Long id) {
        var personagem = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personagem não encontrado"));
        return ResponseEntity.ok(new DadosListagemPersonagem(personagem));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemPersonagem> atualizar (@RequestBody @Valid DadosAtualizacaoPersonagem dados) {
        var personagem = repository.findById(dados.id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personagem não encontrado"));

        personagem.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemPersonagem(personagem));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        var personagem = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personagem não encontrado"));

        personagem.excluir();
        return ResponseEntity.noContent().build();
    }

}

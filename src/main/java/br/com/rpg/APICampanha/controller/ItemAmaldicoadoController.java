package br.com.rpg.APICampanha.controller;

import br.com.rpg.APICampanha.domain.itemAmaldicoado.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
@RequestMapping("/itens")
@SecurityRequirement(name = "bearer-key")
public class ItemAmaldicoadoController {

    @Autowired
    private ItemAmaldicoadoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemItemAmaldicoado> cadastrar (@RequestBody @Valid DadosCadastroItemAmaldicoado dados) {
        var item = new ItemAmaldicoado(dados);
        repository.save(item);
        return ResponseEntity.created(URI.create("/itens" + item.getId()))
                .body(new DadosListagemItemAmaldicoado(item));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemItemAmaldicoado>> listar(@PageableDefault(sort = "elemento") Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemItemAmaldicoado::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemItemAmaldicoado> detalhar (@PathVariable Long id) {
        var item = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Amaldiçoado não encontrado"));
        return ResponseEntity.ok(new DadosListagemItemAmaldicoado(item));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemItemAmaldicoado> atualizar(@RequestBody @Valid DadosAtualizacaoItemAmaldicoado dados) {
        var item = repository.findById(dados.id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Amaldiçoado não encontrado"));

        item.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemItemAmaldicoado(item));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        var item = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Amaldiçoado não encontrado"));

        item.excluir();
        return ResponseEntity.noContent().build();
    }

}

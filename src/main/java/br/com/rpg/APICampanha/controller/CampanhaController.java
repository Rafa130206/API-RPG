package br.com.rpg.APICampanha.controller;

import br.com.rpg.APICampanha.domain.campanha.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("campanhas")
public class CampanhaController {

    @Autowired
    private CampanhaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCampanha dados) {
       repository.save(new Campanha(dados));
    }

    @GetMapping
    public Page<DadosListagemCampanha> listar(@PageableDefault(size = 5)Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemCampanha::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCampanha dados) {
        var campanha = repository.getReferenceById(dados.id());
        campanha.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var campanha = repository.getReferenceById(id);
        campanha.excluir();
    }
}

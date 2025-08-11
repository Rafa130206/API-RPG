package br.com.rpg.APICampanha.controller;

import br.com.rpg.APICampanha.domain.usuario.DadosCadastroUsuario;
import br.com.rpg.APICampanha.domain.usuario.Usuario;
import br.com.rpg.APICampanha.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {
        if (repository.findByLogin(dados.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        var senhaCriptografada = passwordEncoder.encode(dados.senha());
        var usuario = new Usuario(null, dados.login(), senhaCriptografada);
        repository.save(usuario);

        return ResponseEntity.ok().build();
    }
}

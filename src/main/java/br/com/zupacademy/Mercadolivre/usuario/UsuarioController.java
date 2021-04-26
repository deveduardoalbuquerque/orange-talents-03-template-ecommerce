package br.com.zupacademy.Mercadolivre.usuario;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void salvarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest){
        repository.save(usuarioRequest.toUsuario());
    }

    @GetMapping
    public List<Usuario> listarTudo(){
        return repository.findAll();
    }
}

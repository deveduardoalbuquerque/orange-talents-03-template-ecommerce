package br.com.zupacademy.Mercadolivre.categoria;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    private CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Categoria salvarCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest){

        System.out.println(categoriaRequest);
        return repository.save(categoriaRequest.toCategoria());

    }

}

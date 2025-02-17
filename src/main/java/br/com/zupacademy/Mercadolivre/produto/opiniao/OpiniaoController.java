package br.com.zupacademy.Mercadolivre.produto.opiniao;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("opinioes")
public class OpiniaoController {

    private OpiniaoRepository repository;

    public OpiniaoController(OpiniaoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Opiniao salvarOpiniao(@RequestBody @Valid OpiniaoRequest opiniaoRequest){
        return repository.save(opiniaoRequest.toOpiniao());
    }

    @GetMapping
    public List<Opiniao> listarTudo(){
        return repository.findAll();
    }

}

package br.com.zupacademy.Mercadolivre.produto.pergunta;

import br.com.zupacademy.Mercadolivre.produto.Produto;
import br.com.zupacademy.Mercadolivre.produto.ProdutoRepository;
import br.com.zupacademy.Mercadolivre.usuario.Usuario;
import br.com.zupacademy.Mercadolivre.usuario.UsuarioRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("perguntas")
public class PerguntaController {

    private PerguntaRepository perguntaRepository;
    private UsuarioRepository usuarioRepository;
    private ProdutoRepository produtoRepository;

    public PerguntaController(PerguntaRepository perguntaRepository,
                              UsuarioRepository usuarioRepository,
                              ProdutoRepository produtoRepository) {
        this.perguntaRepository = perguntaRepository;
        this.usuarioRepository = usuarioRepository;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public void salvarPergunta(@RequestBody @Valid PergutaRequest pergutaRequest,
                                         Principal principal){

        perguntaRepository.save(pergutaRequest.toPergunta(principal.getName(),usuarioRepository));

        Long idproduto = pergutaRequest.getProduto().getId();

        Optional<Produto> produto = produtoRepository.findById(idproduto);

        if(produto.isPresent()){
            Optional<Usuario> usuario = usuarioRepository.findById(produto.get().getUsuario().getId());
            if(usuario.isPresent()){
                String emailDonoProduto = usuario.get().getEmail();
                SendEmail sendEmail = new SendEmail(principal.getName(),emailDonoProduto,
                        "Uma nova pergunta no seu produto",pergutaRequest.getPergunta());
                System.out.println(sendEmail);
            }
        }

    }
}


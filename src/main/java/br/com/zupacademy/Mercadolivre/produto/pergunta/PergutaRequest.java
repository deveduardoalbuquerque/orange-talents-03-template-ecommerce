package br.com.zupacademy.Mercadolivre.produto.pergunta;

import br.com.zupacademy.Mercadolivre.produto.Produto;
import br.com.zupacademy.Mercadolivre.usuario.Usuario;
import br.com.zupacademy.Mercadolivre.usuario.UsuarioRepository;
import br.com.zupacademy.Mercadolivre.validacao.Groups;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.util.Optional;

public class PergutaRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String pergunta;

    @NotNull
    @Valid
    @ConvertGroup(from = Default.class, to = Groups.Produto.class)
    private Produto produto;


    public PergutaRequest(String titulo, String pergunta, Produto produto) {
        this.titulo = titulo;
        this.pergunta = pergunta;
        this.produto = produto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPergunta() {
        return pergunta;
    }

    public Produto getProduto() {
        return produto;
    }

    public Pergunta toPergunta(String email, UsuarioRepository repository){

        Optional<Usuario> usuarioLogado = repository.findByEmail(email);

        if(usuarioLogado.isPresent()){
            return new Pergunta(this.titulo,this.pergunta,
                    usuarioLogado.get(),this.produto);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuário inválido");


    }
}

package br.com.zupacademy.Mercadolivre.categoria;

import br.com.zupacademy.Mercadolivre.validacao.Groups;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = Groups.Categoria.class)
    private Long id;

    private String nome;

    @ManyToOne
    @JsonIgnore
    private Categoria categoriaMae;

    public Categoria() {
    }

    public Categoria(String nome, Categoria categoriaMae) {
        this.nome = nome;
        this.categoriaMae = categoriaMae;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoriaMae() {
        return categoriaMae;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "Id=" + id +
                ", nome='" + nome + '\'' +
                ", categoriaMae=" + categoriaMae +
                '}';
    }
}

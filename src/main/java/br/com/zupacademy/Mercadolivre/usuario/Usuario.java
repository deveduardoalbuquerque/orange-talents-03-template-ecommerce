package br.com.zupacademy.Mercadolivre.usuario;

import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;

    @Deprecated //uso eclusivo do Hibernate
    public Usuario() {
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
        Assert.isTrue(verificaEntradas(),"Campos não podem ser nulos");
    }

    public boolean verificaEntradas(){
        return this.email != null || this.senha != null;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}

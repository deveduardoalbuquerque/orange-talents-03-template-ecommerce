package br.com.zupacademy.Mercadolivre.usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;

    private LocalDateTime createdAt= LocalDateTime.now();

    @Deprecated //uso eclusivo do Hibernate
    public Usuario() {
    }

    public Usuario(String email, SenhaLimpa senhaLimpa) {
        //tratamento
        Assert.hasLength(email,"Email nao pode ser em branco");
        Assert.notNull(senhaLimpa,"A senha não pode ser em branco");

        this.email = email;
        this.senha = senhaLimpa.hash() ;

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

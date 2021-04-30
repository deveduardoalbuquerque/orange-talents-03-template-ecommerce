package br.com.zupacademy.Mercadolivre.usuario;

import br.com.zupacademy.Mercadolivre.validacao.ExisteCampo;
import br.com.zupacademy.Mercadolivre.validacao.Groups;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = Groups.Usuario.class)
    @ExisteCampo(atributo = "id",aClass = Usuario.class, groups = Groups.Usuario.class)
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

        this.email = email;
        this.senha = senhaLimpa.hash() ;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

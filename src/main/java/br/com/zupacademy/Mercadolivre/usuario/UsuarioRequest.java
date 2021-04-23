package br.com.zupacademy.Mercadolivre.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequest {

    @NotBlank
    @Email
    private String email;
    @NotBlank @Size(min = 6)
    private String senha;

    public UsuarioRequest(@NotBlank @Email String email,
                          @NotBlank @Size(min = 6) String senha) {

        this.email = email;
        this.senha = senha;

    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario toUsuario(){
        return new Usuario(this.email, this.senha);
    }
}

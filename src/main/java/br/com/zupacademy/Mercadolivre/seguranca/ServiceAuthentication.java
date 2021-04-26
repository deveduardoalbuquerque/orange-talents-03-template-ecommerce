package br.com.zupacademy.Mercadolivre.seguranca;

import br.com.zupacademy.Mercadolivre.usuario.Usuario;
import br.com.zupacademy.Mercadolivre.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceAuthentication implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<Usuario> usuario =repository.findByEmail(s);

        if(usuario.isPresent()){
            return usuario.get();
        }

        throw new UsernameNotFoundException("Dados Inválidos!");

    }
}

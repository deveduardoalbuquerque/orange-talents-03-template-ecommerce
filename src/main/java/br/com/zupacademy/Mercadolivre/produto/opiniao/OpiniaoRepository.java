package br.com.zupacademy.Mercadolivre.produto.opiniao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OpiniaoRepository extends JpaRepository<Opiniao, Long> {

    List<Opiniao> findByUsuarioId(Long idUsuario);
}

package br.com.zupacademy.Mercadolivre.produto.pergunta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

    List<Pergunta> findByProdutoAndId(Long idProduto);
}

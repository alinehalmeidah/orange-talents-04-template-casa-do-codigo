package br.com.orangetalents.CasaDoCodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.orangetalents.CasaDoCodigo.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}

package br.com.orangetalents.CasaDoCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.orangetalents.CasaDoCodigo.dto.responses.DetalhesLivroResponse;
import br.com.orangetalents.CasaDoCodigo.entity.Livro;

@RestController
@RequestMapping("/produtos")
public class DetalhesLivroController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("/{id}")
	public ResponseEntity<?>buscarPorId(@PathVariable long id){
		Livro livro = entityManager.find(Livro.class, id);
		
		if(livro == null) {
			return ResponseEntity.notFound().build();
		}
		DetalhesLivroResponse detalhesLivroResponse = new DetalhesLivroResponse(livro);
		
		return ResponseEntity.ok(detalhesLivroResponse);
	}

}

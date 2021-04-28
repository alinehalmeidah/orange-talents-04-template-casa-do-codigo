package br.com.orangetalents.CasaDoCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.CasaDoCodigo.dto.requests.NovoAutorRequest;
import br.com.orangetalents.CasaDoCodigo.entity.Autor;


@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public String cadastrar (@RequestBody @Valid NovoAutorRequest novoAutorRequest) {
		Autor autor = novoAutorRequest.toModel();
		entityManager.persist(autor);
		
		return autor.toString();
	}

}

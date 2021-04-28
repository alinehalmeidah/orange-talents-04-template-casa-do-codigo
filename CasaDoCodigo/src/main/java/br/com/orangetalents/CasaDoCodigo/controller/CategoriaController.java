package br.com.orangetalents.CasaDoCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.CasaDoCodigo.dto.requests.NovaCategoriaRequest;
import br.com.orangetalents.CasaDoCodigo.entity.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public String cadastrar (@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest) {
		Categoria categoria = novaCategoriaRequest.toModel();
		entityManager.persist(categoria);
		
		return categoria.toString();
}
}

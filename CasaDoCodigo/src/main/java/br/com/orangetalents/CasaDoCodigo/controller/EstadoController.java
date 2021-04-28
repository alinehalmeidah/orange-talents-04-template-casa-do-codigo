package br.com.orangetalents.CasaDoCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.orangetalents.CasaDoCodigo.dto.requests.NovoEstadoRequest;
import br.com.orangetalents.CasaDoCodigo.entity.Estado;


@RequestMapping("/estados")
@RestController
public class EstadoController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoEstadoRequest novoEstadoRequest) {
		Estado estado = novoEstadoRequest.toModel(entityManager);
		entityManager.persist(estado);
		
		return "Novo estado cadastrado: " + novoEstadoRequest.getNome();
	}
}

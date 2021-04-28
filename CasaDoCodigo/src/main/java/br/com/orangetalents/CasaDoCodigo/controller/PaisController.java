package br.com.orangetalents.CasaDoCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.orangetalents.CasaDoCodigo.dto.requests.NovoPaisRequest;
import br.com.orangetalents.CasaDoCodigo.entity.Pais;


@RestController
@RequestMapping("/paises")
public class PaisController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoPaisRequest novoPaisRequest) {
		Pais pais = novoPaisRequest.toModel();
		entityManager.persist(pais);
		
		return pais.toString();
	}
}

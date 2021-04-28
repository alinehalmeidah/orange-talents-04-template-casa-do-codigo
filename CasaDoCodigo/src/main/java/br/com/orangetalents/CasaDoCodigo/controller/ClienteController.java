package br.com.orangetalents.CasaDoCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.orangetalents.CasaDoCodigo.dto.requests.NovoClienteRequest;
import br.com.orangetalents.CasaDoCodigo.entity.Cliente;
import br.com.orangetalents.CasaDoCodigo.validation.PaisPossuiEstadoValidator;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private PaisPossuiEstadoValidator validator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoClienteRequest novoClienteRequest) {
		Cliente cliente = novoClienteRequest.toModel(entityManager);
				entityManager.persist(cliente);
		
		return "Novo Id cadastrado" + cliente.getId().toString();
				
		
	}

	
}

package br.com.orangetalents.CasaDoCodigo.dto.requests;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import br.com.orangetalents.CasaDoCodigo.entity.Estado;
import br.com.orangetalents.CasaDoCodigo.entity.Pais;
import br.com.orangetalents.CasaDoCodigo.validation.ExistsId;
import br.com.orangetalents.CasaDoCodigo.validation.UniqueEstadoPais;

@UniqueEstadoPais(domainClass = Estado.class,fieldName1 = "nome",fieldName2 = "idPais")
public class NovoEstadoRequest {
	
	@NotBlank
	private String nome;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id", message = "Pais Inexistente")
	private Long idPais;

	public NovoEstadoRequest() {
	}

	public NovoEstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}
	
	public Estado toModel(EntityManager entityManager) {
		Pais pais = entityManager.find(Pais.class, this.idPais);
		return new Estado(this.nome,pais);
	}
	
	
}
package br.com.orangetalents.CasaDoCodigo.dto.requests;

import javax.validation.constraints.NotBlank;
import br.com.orangetalents.CasaDoCodigo.entity.Pais;
import br.com.orangetalents.CasaDoCodigo.validation.UniqueValue;

public class NovoPaisRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "Campo nome deve ser único.")
	private String nome;

	@Deprecated
	public NovoPaisRequest() {
	}

	public NovoPaisRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Pais toModel() {
		return new Pais(this.nome);
	}
	

}

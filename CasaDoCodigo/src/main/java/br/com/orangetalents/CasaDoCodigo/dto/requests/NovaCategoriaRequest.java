package br.com.orangetalents.CasaDoCodigo.dto.requests;

import javax.validation.constraints.NotBlank;
import br.com.orangetalents.CasaDoCodigo.entity.Categoria;
import br.com.orangetalents.CasaDoCodigo.validation.UniqueValue;

public class NovaCategoriaRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "nome da categoria deve ser unico")
	private String nome;

	@Deprecated
	public NovaCategoriaRequest() {
	}

	public NovaCategoriaRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Categoria toModel() {
		return new Categoria(this.nome);
	}


	
}

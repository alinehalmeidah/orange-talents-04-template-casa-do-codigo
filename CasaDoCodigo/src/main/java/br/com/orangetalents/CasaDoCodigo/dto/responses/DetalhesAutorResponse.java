package br.com.orangetalents.CasaDoCodigo.dto.responses;

import br.com.orangetalents.CasaDoCodigo.entity.Autor;

public class DetalhesAutorResponse {
	
	private String nome;
	private String descricao;
		
	public DetalhesAutorResponse() {
	}

	public DetalhesAutorResponse(Autor autor) {
		nome = autor.getNome();
	    descricao =autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
}
package br.com.orangetalents.CasaDoCodigo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@ManyToOne
	private Pais pais;

	
	@Deprecated
	public Estado() {
	}


	public Estado(@NotBlank String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public Pais getPais() {
		return pais;
	}


	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
	}
	
				

}

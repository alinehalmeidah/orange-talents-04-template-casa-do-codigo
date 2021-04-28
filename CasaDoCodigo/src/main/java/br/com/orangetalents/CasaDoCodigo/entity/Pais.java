package br.com.orangetalents.CasaDoCodigo.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@OneToMany(mappedBy ="pais",cascade = CascadeType.ALL)
	private List<Estado> estados;

	
	@Deprecated
	public Pais() {
	}


	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}


	public String getNome() {
		return nome;
	}


	public List<Estado> getEstados() {
		return estados;
	}


	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + ", estados=" + estados + "]";
	}
	
}

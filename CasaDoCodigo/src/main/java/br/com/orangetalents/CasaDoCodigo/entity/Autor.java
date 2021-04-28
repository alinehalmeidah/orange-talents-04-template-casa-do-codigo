package br.com.orangetalents.CasaDoCodigo.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.sun.istack.NotNull;


@Entity
public class Autor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private String nome;
	
	@Email
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String email;
	
	@NotNull
	@NotEmpty
	@Size(max = 400)
	private String descricao;
	
	
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Deprecated
	public Autor() {
	}

	public Autor(@NotEmpty String nome, @Email @NotEmpty String email, @NotEmpty 
	@Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao + ", dataCriacao="
				+ dataCriacao + "]";
	}
	
	
	
	
	
	
}

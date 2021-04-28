package br.com.orangetalents.CasaDoCodigo.dto.requests;

import java.time.LocalDateTime;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.sun.istack.NotNull;
import br.com.orangetalents.CasaDoCodigo.entity.Autor;
import br.com.orangetalents.CasaDoCodigo.validation.UniqueValue;

public class NovoAutorRequest {
	
	@NotNull
	@NotEmpty
	private String nome;
	
	@Email
	@NotNull
	@NotEmpty
	@UniqueValue(domainClass = Autor.class, fieldName = "email", message ="E-mail deve ser unico")
	private String email;
	
	@NotNull
	@NotEmpty
	@Size (max = 400)
	private String descricao;
	
	private LocalDateTime dataCriacao = LocalDateTime.now();

	public NovoAutorRequest() {
	}

	public NovoAutorRequest(@NotEmpty String nome, @Email @NotEmpty String email,
			@NotEmpty @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
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
	
	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
		
	}
	
	
	
	
	
}

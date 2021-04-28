package br.com.orangetalents.CasaDoCodigo.dto.requests;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.util.Assert;

import com.sun.istack.NotNull;

import br.com.orangetalents.CasaDoCodigo.entity.Cliente;
import br.com.orangetalents.CasaDoCodigo.entity.Estado;
import br.com.orangetalents.CasaDoCodigo.entity.Pais;
import br.com.orangetalents.CasaDoCodigo.validation.CpfOuCnpj;
import br.com.orangetalents.CasaDoCodigo.validation.ExistsId;
import br.com.orangetalents.CasaDoCodigo.validation.UniqueValue;

public class NovoClienteRequest {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@Email
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	
	@NotBlank
	@CpfOuCnpj
	@UniqueValue(domainClass = Cliente.class,fieldName = "documento")
	private String documento;
	
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	
	@ExistsId(domainClass = Estado.class, fieldName = "id")
	private Long idEstado;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;

	public NovoClienteRequest() {
	}

	public NovoClienteRequest(@NotBlank String nome, @NotBlank String sobrenome, @Email @NotBlank String email,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
			Long idPais, Long idEstado, @NotBlank String telefone, @NotBlank String cep) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
	
	public Cliente toModel(EntityManager entityManager) {
		Pais pais = entityManager.find(Pais.class, idPais);
        Estado estado = entityManager.find(Estado.class, this.idEstado);

        Assert.state(pais != null, "País não pode ser nulo.");
        Assert.state(estado != null, "Estado não pode ser nulo.");

        return new Cliente(this.nome, this.sobrenome, this.email, this.documento, this.endereco,
                this.complemento, this.cidade, pais, estado, this.telefone, this.cep);
	}
	
}

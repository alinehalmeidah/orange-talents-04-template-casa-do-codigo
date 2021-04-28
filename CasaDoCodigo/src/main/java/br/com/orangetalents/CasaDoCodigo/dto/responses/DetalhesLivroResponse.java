package br.com.orangetalents.CasaDoCodigo.dto.responses;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import br.com.orangetalents.CasaDoCodigo.entity.Livro;

public class DetalhesLivroResponse {
	
	private DetalhesAutorResponse autor;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer paginas;
    private String isbn;    
    private String dataPublicacao;

    @Deprecated
    public DetalhesLivroResponse() {
    }
    
    public DetalhesLivroResponse(Livro livro) {
    	autor = new DetalhesAutorResponse(livro.getIdAutor());
    	titulo = livro.getTitulo();
    	resumo = livro.getResumo();
    	sumario = livro.getSumario();
    	preco = livro.getPreco();
    	paginas = livro.getPaginas();
    	isbn = livro.getIsbn();
    	dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    			
    }

	public DetalhesAutorResponse getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}
    
   

}

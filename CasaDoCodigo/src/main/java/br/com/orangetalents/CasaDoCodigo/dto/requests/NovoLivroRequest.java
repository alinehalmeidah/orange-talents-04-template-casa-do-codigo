package br.com.orangetalents.CasaDoCodigo.dto.requests;

import br.com.orangetalents.CasaDoCodigo.entity.Autor;
import br.com.orangetalents.CasaDoCodigo.entity.Categoria;
import br.com.orangetalents.CasaDoCodigo.entity.Livro;
import br.com.orangetalents.CasaDoCodigo.validation.ExistsId;
import br.com.orangetalents.CasaDoCodigo.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.util.Assert;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Título deve ser único")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer paginas;

    @UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "ISBN deve ser único.")
    private String isbn;

    @NotNull
    @Future
    @JsonIgnoreProperties(value = {"dataPublicacao"}, ignoreUnknown = true, allowSetters = true)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @ManyToOne
    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;

    @ManyToOne
    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    @Deprecated
    public NovoLivroRequest() {
    }

    public NovoLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
                            @NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer paginas, String isbn,
                            @NotNull @Future LocalDate dataPublicacao, @NotNull Long idCategoria,
                            @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro toModel(EntityManager entityManager) {
        @NotNull
        Autor autor = entityManager.find(Autor.class, this.idAutor);

        @NotNull
        Categoria categoria = entityManager.find(Categoria.class, this.idCategoria);

        Assert.state(autor != null,
                "Você está tentando cadastrar um livro para um autor que não existe no banco: " + this.idAutor);
        Assert.state(categoria != null,
                "Você está tentando cadastrar um livro para uma categoria que não existe no banco: "
                        + this.idCategoria);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.paginas, this.isbn,
                this.dataPublicacao, categoria, autor);
    }
}
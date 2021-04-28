package br.com.orangetalents.CasaDoCodigo.controller;

import br.com.orangetalents.CasaDoCodigo.dto.requests.NovoLivroRequest;
import br.com.orangetalents.CasaDoCodigo.entity.Livro;
import br.com.orangetalents.CasaDoCodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public String cadastrar(@RequestBody @Valid NovoLivroRequest novoLivroRequest) {
        Livro livro = novoLivroRequest.toModel(entityManager);

        entityManager.persist(livro);

        return livro.toString();
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        return ResponseEntity.ok(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
        return livroRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }
}
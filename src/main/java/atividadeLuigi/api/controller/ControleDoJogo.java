package atividadeLuigi.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import atividadeLuigi.api.model.Jogo;
import atividadeLuigi.api.repository.JogoRepositorio;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogos")
public class ControleDoJogo {

    private final JogoRepositorio repository;

    public ControleDoJogo(JogoRepositorio repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> listarTodos() {

        return ResponseEntity.ok(
                repository.findAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscarPorId(
            @PathVariable Long id
    ) {

        Optional<Jogo> jogo = repository.findById(id);

        if (jogo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(jogo.get());
    }

    @PostMapping
    public ResponseEntity<Jogo> cadastrar(
            @RequestBody Jogo jogo
    ) {

        Jogo salvo = repository.save(jogo);

        return ResponseEntity.status(201).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizar(
            @PathVariable Long id,
            @RequestBody Jogo jogoAtualizado
    ) {

        Optional<Jogo> jogoExistente = repository.findById(id);

        if (jogoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Jogo jogo = jogoExistente.get();

        jogo.setNome(jogoAtualizado.getNome());
        jogo.setTipo(jogoAtualizado.getTipo());
        jogo.setNota(jogoAtualizado.getNota());
        jogo.setComentario(jogoAtualizado.getComentario());

        Jogo salvo = repository.save(jogo);

        return ResponseEntity.ok(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id
    ) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}

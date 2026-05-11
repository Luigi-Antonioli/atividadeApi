package atividadeLuigi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import atividadeLuigi.api.model.Jogo;

public interface JogoRepositorio extends JpaRepository<Jogo, Long> {
}

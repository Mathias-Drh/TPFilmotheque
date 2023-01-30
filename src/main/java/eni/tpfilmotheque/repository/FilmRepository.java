package eni.tpfilmotheque.repository;

import eni.tpfilmotheque.bo.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface FilmRepository extends JpaRepository<Film, Long> {
    Film findByTitre(String titre);
}

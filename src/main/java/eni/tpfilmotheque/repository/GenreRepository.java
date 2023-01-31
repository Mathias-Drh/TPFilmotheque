package eni.tpfilmotheque.repository;

import eni.tpfilmotheque.bo.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface GenreRepository extends JpaRepository<Genre, Long> {
}

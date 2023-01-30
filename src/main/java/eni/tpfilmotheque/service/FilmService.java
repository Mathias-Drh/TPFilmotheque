package eni.tpfilmotheque.service;

import eni.tpfilmotheque.bo.Film;

import java.util.List;
import java.util.Optional;

public interface FilmService {

    Optional<Film> getOneById(Long id);
    List<Film> getAll();
    void insertOrUpdateFilm(Film film);
    void delFilm(Film film);

    Film findOneByTitre(String titre);

}

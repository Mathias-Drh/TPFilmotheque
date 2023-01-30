package eni.tpfilmotheque.service;

import eni.tpfilmotheque.bo.Film;
import eni.tpfilmotheque.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService{

    private FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    @Override
    public Optional<Film> getOneById(Long id) {
        return filmRepository.findById(id);
    }

    @Override
    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    @Override
    public void insertOrUpdateFilm(Film film) {
        filmRepository.save(film);
    }

    @Override
    public void delFilm(Film film) {
        filmRepository.delete(film);
    }

    @Override
    public Film findOneByTitre(String titre) {
        return findOneByTitre(titre);
    }
}

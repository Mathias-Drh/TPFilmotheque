package eni.tpfilmotheque.service;

import eni.tpfilmotheque.bo.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Optional<Genre> getById(Long id);
    List<Genre> getAll();
}

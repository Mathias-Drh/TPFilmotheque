package eni.tpfilmotheque.controller;

import eni.tpfilmotheque.bo.Film;
import eni.tpfilmotheque.bo.Genre;
import eni.tpfilmotheque.service.FilmService;
import eni.tpfilmotheque.service.GenreService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("film")
public class FilmController {

    private FilmService filmService;
    private GenreService genreService;

    public FilmController(FilmService filmService, GenreService genreService) {
        this.filmService = filmService;
        this.genreService = genreService;
    }

    @RequestMapping("/film{id}")
    public String loadView(Model model, HttpSession session,
                           @RequestParam("id") Long id) {

        model.addAttribute("film", filmService.getOneById(id).orElse(new Film()));
//        ArrayList<Film> films = (ArrayList<Film>) session.getAttribute("films");
//        if (films == null) {
//            films = new ArrayList<>();
//            session.setAttribute("films", films);
//        }
        return "home";
    }

    @RequestMapping({"/liste-films", "/"})
    public String loadALl(Model model, HttpSession session) {
//        ArrayList<Film> films = (ArrayList<Film>) session.getAttribute("films");
//        if (films == null) {
//            films = new ArrayList<>();
//            session.setAttribute("films", films);
//        }
        model.addAttribute("films", filmService.getAll());
        return "listefilms";
    }

    @RequestMapping("/ajouter-film")
    public String loadAdd(Model model) {
        model.addAttribute("genres", genreService.getAll());
        return "ajouterfilm";
    }
    @RequestMapping("/ajouter-film-obj")
    public String loadAddObj(Model model) {
        model.addAttribute("film", new Film());
        model.addAttribute("obj","obj");
        model.addAttribute("genres", genreService.getAll());
        return "ajouterfilm";
    }

    @RequestMapping("/action-ajouter-film")
    public String addFilm(Model model,
//                          @Valid @ModelAttribute("film") Film film,
                          //BindingResult validationResult,
                          @RequestParam("titre") String titre,
                          @RequestParam("duree") int duree,
                          @RequestParam("annee") int annee,
                          @RequestParam("synopsis") String synopsis,
                          @RequestParam("idG") List<Long> idG
    ) {
        /*if (validationResult.hasErrors()) {
            String err = "Vous avez une erreur dans le champs " + validationResult.getFieldError().getField();
            model.addAttribute("erreur", err);
            return "ajouterfilm";
        }*/
        System.out.println(titre + " " + duree + " " + annee + " " + synopsis);
        Film film = new Film(titre, duree, annee, synopsis);
        List<Genre> genres = new ArrayList<>();
        for (Long id : idG) {
            genres.add(genreService.getById(id).orElseThrow());
        }
        film.setGenre(genres);
        //film.getGenre().add(genre);
        System.out.println(idG);
        System.out.println(film.getGenre());
        filmService.insertOrUpdateFilm(film);
        //films.add(film);
        return "redirect:/liste-films";
    }
    @RequestMapping("/action-ajouter-film-obj")
    public String addFilmObj(Model model,
                         @Valid @ModelAttribute("film") Film film,
                          BindingResult validationResult,
                          @RequestParam("idG") List<Long> idG
    ) {
        if (validationResult.hasErrors()) {
            String err = "Vous avez une erreur dans le champs " + validationResult.getFieldError().getField();
            model.addAttribute("erreur", err);
            return "ajouterfilm";
        }
        //System.out.println(titre + " " + duree + " " + annee + " " + synopsis);
        //Film film = new Film(titre, duree, annee, synopsis);
        List<Genre> genres = new ArrayList<>();
        for (Long id : idG) {
            genres.add(genreService.getById(id).orElseThrow());
        }
        film.setGenre(genres);
        System.out.println(film);
        //film.getGenre().add(genre);
//        System.out.println(idG);
//        System.out.println(film.getGenre());
       filmService.insertOrUpdateFilm(film);
        //films.add(film);
        return "redirect:/liste-films";
    }

    @RequestMapping("/action-del-film")
    public String delFilm(@RequestParam("id") Long id) {
        filmService.delFilm(filmService.getOneById(id).orElseThrow());
        return "redirect:/liste-films";
    }
}

package eni.tpfilmotheque.controller;

import eni.tpfilmotheque.bo.Film;
import eni.tpfilmotheque.service.FilmService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
//@SessionAttributes("films")
public class FilmController {

    private FilmService filmService;

    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }

    @RequestMapping("/film{id}")
    public String loadView(Model model, HttpSession session,
                           @RequestParam("id")Long id) {

        model.addAttribute("film", filmService.getOneById(id).orElse(new Film()));
//        ArrayList<Film> films = (ArrayList<Film>) session.getAttribute("films");
//        if (films == null) {
//            films = new ArrayList<>();
//            session.setAttribute("films", films);
//        }
        return "home";
    }

    @RequestMapping({"/liste-films","/"})
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
    public String loadAdd() {
        return "ajouterfilm";
    }

    @RequestMapping("/action-ajouter-film")
    public String addFilm(Model model,
//                          @Valid @ModelAttribute("film") Film film,
                          //BindingResult validationResult,
                          @RequestParam("titre")String titre,
                          @RequestParam("duree")int duree,
                          @RequestParam("annee")int annee,
                          @RequestParam("synopsis")String synopsis
                          ) {
        /*if (validationResult.hasErrors()) {
            String err = "Vous avez une erreur dans le champs " + validationResult.getFieldError().getField();
            model.addAttribute("erreur", err);
            return "ajouterfilm";
        }*/
        System.out.println(titre + " " +duree+ " " +annee+ " "+synopsis);
        filmService.insertOrUpdateFilm(new Film(titre, duree, annee, synopsis));
        //films.add(film);
        return "redirect:/liste-films";
    }

    @RequestMapping("/action-del-film")
    public String delFilm(@RequestParam("id")Long id){
        filmService.delFilm(filmService.getOneById(id).orElseThrow());
       return "redirect:/liste-films";
    }
}

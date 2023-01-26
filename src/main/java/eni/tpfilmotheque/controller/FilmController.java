package eni.tpfilmotheque.controller;

import eni.tpfilmotheque.bo.Film;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;

@Controller
@SessionAttributes("films")
public class FilmController {

    @RequestMapping("/")
    public String loadView(Model model, HttpSession session) {
        ArrayList<Film> films = (ArrayList<Film>) session.getAttribute("films");
        if (films == null) {
            films = new ArrayList<>();
            session.setAttribute("films", films);
        }
        model.addAttribute("film", new Film(1, "Inception", 2011, 150, "C'est dans un rêve voilà."));
        return "home";
    }

    @RequestMapping("/liste-films")
    public String loadALl(Model model, HttpSession session) {
        ArrayList<Film> films = (ArrayList<Film>) session.getAttribute("films");
        if (films == null) {
            films = new ArrayList<>();
            session.setAttribute("films", films);
        }
        model.addAttribute("films", films);
        return "listefilms";
    }

    @RequestMapping("/ajouter-film")
    public String loadAdd() {
        return "ajouterfilm";
    }

    @RequestMapping("/action-ajouter-film")
    public String addFilm(Model model, @ModelAttribute("films") ArrayList<Film> films, @Valid @ModelAttribute("film") Film film, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            String err = "Vous avez une erreur dans le champs " + validationResult.getFieldError().getField();
            model.addAttribute("erreur", err);
            return "ajouterfilm";
        }
        films.add(film);
        return "redirect:/liste-films";
    }
}

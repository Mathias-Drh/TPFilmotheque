package eni.tpfilmotheque.controller;

import eni.tpfilmotheque.bo.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class FilmController {

    @RequestMapping("/")
    public String loadView(Model model) {
        model.addAttribute("film", new Film(1, "Inception", 2011, 150, "C'est dans un rêve voilà."));
        return "home";
    }
    @RequestMapping("/liste-films")
    public String loadALl(Model model) {
        ArrayList<Film> films = new ArrayList<Film>();
        films.add(new Film(1, "Inception", 2011, 150, "C'est dans un rêve voilà."));
        films.add(new Film(2, "Avatar 2", 2022, 320, "C'est un film avec des gens bleus."));
        films.add(new Film(3, "Transformers", 2007, 150, "Y'a des robots qui se transforment."));
        model.addAttribute("films", films);
        return "listefilms";
    }
}

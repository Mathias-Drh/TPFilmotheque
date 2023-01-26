package eni.tpfilmotheque.config;

import eni.tpfilmotheque.bo.Film;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;

@Configuration
public class Config {

    @Bean
    @SessionScope
    public ArrayList<Film> films() {
        return new ArrayList<>();
    }
}

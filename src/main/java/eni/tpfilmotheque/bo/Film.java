package eni.tpfilmotheque.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Film {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank(message = "Titre obligatoire")
    private String titre;
    private int annee;
    @Min(value = 0)
    private int duree;
    @Size(min = 20, max = 250)
    private String synopsis;

    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER) //pas delete
    @JoinTable(name="GenreFilm",
            joinColumns= {@JoinColumn(name="film_id")},
            inverseJoinColumns= {@JoinColumn(name="genre_id")}
    )
    private List<Genre> genre;

    public Film(String titre, int annee, int duree, String synopsis) {
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
        this.genre = new ArrayList<>();
    }

    public Film() {}

    @Override
    public String toString() {
        return "Film{" +
                ", titre='" + titre + '\'' +
                ", annee=" + annee +
                ", duree=" + duree +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}

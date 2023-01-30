package eni.tpfilmotheque.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

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

    public Film(String titre, int annee, int duree, String synopsis) {
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
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

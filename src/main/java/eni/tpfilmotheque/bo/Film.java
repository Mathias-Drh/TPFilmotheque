package eni.tpfilmotheque.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Film {

    private long id;
    private String titre;
    private int annee;
    private int duree;
    private String synopsis;

    public Film(long id, String titre, int annee, int duree, String synopsis) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
    }

    public Film() {}

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", annee=" + annee +
                ", duree=" + duree +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}

package eni.tpfilmotheque.bo;



public class Genre {

    private Integer id;
    
    private String libelle;


    public Genre(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Genre() {

    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


}

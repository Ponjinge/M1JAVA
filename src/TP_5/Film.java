package TP_5;

public class Film {
    private long code;

    private String titre;

    private String genre;

    private long idAuteur;

    public Film(String titre, String genre, long idAuteur) {
        this.titre = titre;
        this.genre = genre;
        this.idAuteur = idAuteur;
    }

    public Film(long code, String titre, String genre, long idAuteur) {
        this.code = code;
        this.titre = titre;
        this.genre = genre;
        this.idAuteur = idAuteur;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getCode() {
        return code;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public long getIdAuteur() {
        return idAuteur;
    }

    public void setIdAuteur(long idAuteur) {
        this.idAuteur = idAuteur;
    }

    @Override
    public String toString() {
        return "Film{" + "code=" + code + ", titre='" + titre + '\'' + ", genre='" + genre + '\'' + ", idAuteur=" + idAuteur + '}';
    }
}

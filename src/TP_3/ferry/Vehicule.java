package TP_3.ferry;

/**
 * Classe abstraite Vehicule.
 */
public abstract class Vehicule implements Comparable<Vehicule> {
    /*----- Constantes -----*/
    protected static final double POIDS_MOYEN_PASSAGER = 65.0;

    /*----- Propriétés -----*/
    private String immat;
    private double poidsVide;
    private double largeur;
    private double longueur;
    private double hauteur;

    /*----- Constructeur -----*/
    public Vehicule(String immat, double poidsVide, double largeur, double longueur, double hauteur) {
        this.immat = immat;
        this.poidsVide = poidsVide;
        this.largeur = largeur;
        this.longueur = longueur;
        this.hauteur = hauteur;
    }

    /*----- Setter / Getter -----*/
    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public double getPoidsVide() {
        return poidsVide;
    }

    public void setPoidsVide(double poidsVide) {
        this.poidsVide = poidsVide;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    /*----- Méthodes abstraites -----*/
    public abstract double chargeTotale();

    public abstract int nbPassagers();

    // Comparer deux véhicules en fonction de la hauteur
    @Override
    public int compareTo(Vehicule o) {
        return Double.compare(this.hauteur, o.hauteur);
    }

    @Override
    public String toString() {
        return "Vehicule{" + "immat='" + immat + '\'' + ", poidsVide=" + poidsVide + ", largeur=" + largeur + ", longueur=" + longueur + ", hauteur=" + hauteur + '}';
    }
} /*----- Fin de la classe Vehicule -----*/

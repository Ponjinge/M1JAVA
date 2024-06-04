package TP_3.ferry;

/**
 * Classe Voiture.
 */
// Une voiture est un véhicule.
public class Voiture extends Vehicule {
    /*----- Propriétés -----*/
    private int nbPassagers;

    /*----- Constructeurs -----*/
    public Voiture(String numero, double largeur, double longueur, double hauteur, double poids, int nbPassagers) {
        super(numero, poids, largeur, longueur, hauteur);

        this.nbPassagers = nbPassagers;
    }

    // Méthodes
    @Override
    public double chargeTotale() {
        return this.getPoidsVide() + this.nbPassagers * POIDS_MOYEN_PASSAGER;
    }

    @Override
    public int nbPassagers() {
        return this.nbPassagers;
    }

    // toString()
    @Override
    public String toString() {
        return "Voiture{" + "immat='" + this.getImmat() + ", poidsVide=" + this.getPoidsVide() + ", largeur=" + this.getLargeur() + ", longueur=" + this.getLongueur() + ", hauteur=" + this.getHauteur() + ", nbPassagers=" + this.nbPassagers + '}';
    }
} /*----- Fin de la classe Voiture -----*/

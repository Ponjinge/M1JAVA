package TP_3.ferry;

/**
 * Classe Camion.
 */
public class Camion extends Vehicule {
    /*----- Propriétés -----*/
    private double poidsChargement;

    /*----- Constructeurs -----*/
    public Camion(String numero, double poids, double largeur, double longueur, double hauteur, double poidsChargement) {
        super(numero, poids, largeur, longueur, hauteur);

        this.poidsChargement = poidsChargement;
    }

    /*----- Setter / Getter -----*/
    public double getPoidsChargement() {
        return this.poidsChargement;
    }

    public void setPoidsChargement(double poidsChargement) {
        this.poidsChargement = poidsChargement;
    }

    // Méthodes
    @Override
    public double chargeTotale() {
        return this.getPoidsVide() + this.poidsChargement + POIDS_MOYEN_PASSAGER;
    }

    @Override
    public int nbPassagers() {
        return 1;
    }

    // toString()
    @Override
    public String toString() {
        return "Camion{" + "immat='" + this.getImmat() +  ", poidsVide=" + this.getPoidsVide() + ", largeur=" + this.getLargeur() + ", longueur=" + this.getLongueur() + ", hauteur=" + this.getHauteur() + ", nbPassagers=" + 1 + ", poidsChargement=" + this.poidsChargement + '}';
    }
} /*----- Fin de la classe Camion -----*/

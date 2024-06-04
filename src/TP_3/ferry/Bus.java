package TP_3.ferry;

/**
 * Classe Bus.
 */
public class Bus extends Vehicule {
    /*----- Constantes -----*/
    protected static final double POIDS_MOYEN_BAGAGES_PAR_PASSAGER = 20.0;

    /*----- Propriétés -----*/
    private int nbPassagers;

    /*----- Constructeurs -----*/
    public Bus(String numero, double poids, double largeur, double longueur, double hauteur, int nbPassagers) {
        super(numero, poids, largeur, longueur, hauteur);
        this.nbPassagers = nbPassagers;
    }

    // Méthodes
    @Override
    public double chargeTotale() {
        return this.getPoidsVide() + this.nbPassagers * POIDS_MOYEN_PASSAGER + this.nbPassagers * Bus.POIDS_MOYEN_BAGAGES_PAR_PASSAGER;
    }

    @Override
    public int nbPassagers() {
        return this.nbPassagers;
    }

    // toString
    @Override
    public String toString() {
        return "Bus{" + "immat='" + this.getImmat() +  ", poidsVide=" + this.getPoidsVide() + ", largeur=" + this.getLargeur() + ", longueur=" + this.getLongueur() + ", hauteur=" + this.getHauteur() + ", nbPassagers=" + this.nbPassagers + '}';
    }
} /*----- Fin de la classe Bus -----*/

package TP_3.triplet;

import TP_3.ferry.Bus;
import TP_3.ferry.Camion;
import TP_3.ferry.Vehicule;
import TP_3.ferry.Voiture;

import java.util.Arrays;

public class TripletUnType<E extends Comparable<E>> {

    // Propriétés
    private E objet1;
    private E objet2;
    private E objet3;

    // Constructeurs
    public TripletUnType(E objet1, E objet2, E objet3) {
        this.objet1 = objet1;
        this.objet2 = objet2;
        this.objet3 = objet3;
    }

    // Getters / Setters
    public E getObjet1() {
        return this.objet1;
    }

    public void setObjet1(E objet1) {
        this.objet1 = objet1;
    }

    public E getObjet2() {
        return this.objet2;
    }

    public void setObjet2(E objet2) {
        this.objet2 = objet2;
    }

    public E getObjet3() {
        return this.objet3;
    }

    public void setObjet3(E objet3) {
        this.objet3 = objet3;
    }

    @Override
    public String toString() {
        return "Triplet{" +
                "objet1=" + this.objet1 +
                ", objet2=" + this.objet2 +
                ", objet3=" + this.objet3 +
                '}';
    }

    // Méthodes
    // Retourne le maximum des trois objets
    public E max() {
        if (objet1.compareTo(objet2) > 0) {
            if (objet1.compareTo(objet3) > 0) {
                return objet1;
            } else {
                return objet3;
            }
        } else {
            if (objet2.compareTo(objet3) > 0) {
                return objet2;
            } else {
                return objet3;
            }
        }
    }

    // Retourne le minimum dans un tableau d'éléments comparables
    public static <T extends Comparable<T>> T min(T[] tab) {
        if (tab.length == 0) {
            return null;
        }
        T elementMin = tab[0];
        for (int i = 1; i < tab.length; i++) {
            if (tab[i].compareTo(elementMin) < 0) {
                elementMin = tab[i];
            }
        }
        return elementMin;
    }


    public static void main(String[] args) {
        // Créer des triplets de types différents et afficher le max de ces triplets avec la méthode max()
        TripletUnType<String> ts = new TripletUnType<>("C", "A", "B");
        System.out.println(ts + " ---> " + ts.max());
        TripletUnType<Double> td = new TripletUnType<>(2.0, -3.5, 1.7);
        System.out.println(td + " ---> " + td.max());
        TripletUnType<Vehicule> tv = new TripletUnType<>(new Voiture("Voiture", 2.0, 3.0, 1.75, 1100, 5),
                new Camion("C1", 3455, 2.3, 3.3, 2.3, 80),
                new Bus("B1", 1234, 3.4, 5.0, 3.1, 64));
        System.out.println(tv + " ---> " + tv.max());

        // Créer un tableau d'entiers et un tableau de chaînes de caractères
        Integer[] nombres = {3, 7, 1, 0, -3, 2};
        String[] chaines = {"masters", "tableau", "arraylist"};
        // Afficher le min de ces tableaux avec la méthode TripletUnType.min()
        System.out.println("L'élément le plus petit dans le tableau " + Arrays.toString(nombres) + " est " + TripletUnType.min(nombres));
        System.out.println("L'élément le plus petit dans le tableau " + Arrays.toString(chaines) + " est " + TripletUnType.min(chaines));
    }
}


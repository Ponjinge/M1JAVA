package TP_3.file;

import TP_3.ferry.Bus;
import TP_3.ferry.Vehicule;
import TP_3.ferry.Voiture;

import java.util.ArrayList;
import java.util.Collection;

public class FileAttenteGenerique<E> {

    // Propriétés
    private int capacite;

    private ArrayList<E> elements;

    // Constructeurs
    public FileAttenteGenerique(int capacite) {
        this.capacite = capacite;
        this.elements = new ArrayList<>(capacite);
    }

    //Getters

    public int getCapacite() {
        return capacite;
    }

    public ArrayList<E> getElements() {
        return elements;
    }

    // Ajoute un élément dans la liste d'attente
    public boolean addElement(E element) {
        if (this.capacite == this.elements.size()) {
            return false;
        } else {
            return this.elements.add(element);
        }
    }

    // Enlève le premier élément
    public E removeFirstElement() {
        if (this.elements.isEmpty()) {
            return null;
        }
        return this.elements.removeFirst();
    }

    // Enlève un élément
    public boolean removeElement(E element) {
        return this.elements.remove(element);
    }

    // toString()
    @Override
    public String toString() {
        String ch = "{ ";
        for (E c : this.elements) {
            ch += c + " ";
        }
        ch += "}";
        return ch;
    }

    // WILCARD
    public static <T> void addAll(FileAttenteGenerique<T> file, Collection<T> elements) {
        // Check to see if there is enough space left for the whole arraylist being added
        if (file.getElements().size() + elements.size() > file.getCapacite()) {
            return;
        }
        // Add each element
        for (T element : elements) {
            file.addElement(element);
        }
    }

    // Bonus
    public static <T> void addSome(FileAttenteGenerique<T> file, Collection<T> elements) {

        for (T element : elements) {
            if (file.getElements().size() < file.getCapacite()) {
                file.addElement(element);
            } else {
                return;
            }
        }
    }


    public static void main(String[] args) {
        // On crée une file d'attente de String
        FileAttenteGenerique<String> fs = new FileAttenteGenerique(3);
        System.out.println("--Strings--");
        // Ajouter des éléments dans la file et afficher l'état de la file après chaque ajout
        fs.addElement("A");
        System.out.println(fs);
        fs.addElement("B");
        System.out.println(fs);
        fs.addElement("C");
        System.out.println(fs);
        fs.addElement("D");
        System.out.println(fs);
        // Supprimer l'élément "A" de la liste
        fs.removeElement("A");
        System.out.println(fs);
        // Supprimer le premier élément de la liste
        fs.removeFirstElement();
        System.out.println(fs);

        // Créer une file d'attente d'entiers
        FileAttenteGenerique<Integer> fi = new FileAttenteGenerique<>(4);
        System.out.println("--Entiers--");
        // Ajouter des éléments dans la file
        fi.addElement(4);
        fi.addElement(8);
        fi.addElement(8);
        fi.addElement(8);
        fi.addElement(4);
        fi.addElement(2);
        fi.addElement(6);
        fi.addElement(11);
        // Afficher l'état de la file
        System.out.println(fi);


        //Cars
        Voiture v2 = new Voiture("Voiture 2", 2.2, 2.54, 1, 1100, 1);
        Voiture v3 = new Voiture("Voiture 3", 2.2, 2.54, 1, 1100, 3);
        Voiture v4 = new Voiture("Voiture 4", 2.2, 2.54, 1, 1100, 4);

        // Buses
        Bus b2 = new Bus("B2", 3500, 2.00, 21.0, 3.5, 60);
        Bus b3 = new Bus("B3", 1500, 2.30, 15.0, 3, 23);
        Bus b4 = new Bus("B4", 1500, 2.30, 15.0, 3, 23);
        Bus b5 = new Bus("B5", 1500, 2.30, 15.0, 3, 23);

        // On crée une file d'attente de Vehicules
        FileAttenteGenerique<Vehicule> vehiculeFile = new FileAttenteGenerique(3);
        System.out.println("--vehiculeFile--");
        // Ajouter des éléments dans la file et afficher l'état de la file après chaque ajout
        vehiculeFile.addElement(b2);
        System.out.println(vehiculeFile);
        vehiculeFile.addElement(v2);
        System.out.println(vehiculeFile);
        vehiculeFile.addElement(b3);
        System.out.println(vehiculeFile);
        vehiculeFile.addElement(v4);
        System.out.println(vehiculeFile);
        // Supprimer la voiture v2 de la liste
        vehiculeFile.removeElement(v2);
        System.out.println(vehiculeFile);
        // Supprimer le premier élément de la liste
        vehiculeFile.removeFirstElement();
        System.out.println(vehiculeFile);

        System.out.println("--busFile--");
        // On crée une file d'attente de Bus
        FileAttenteGenerique<Bus> busFile = new FileAttenteGenerique(3);

        // Ajouter des éléments dans la file et afficher l'état de la file après chaque ajout
        busFile.addElement(b2);
        System.out.println(busFile);
        busFile.addElement(b3);
        System.out.println(busFile);
        // Supprimer le bus b3  de la liste
        busFile.removeElement(b3);
        System.out.println(busFile);
        // Supprimer le premier élément de la liste
        busFile.removeFirstElement();
        System.out.println(busFile);

        //WILCARD
        System.out.println("--WILCARD--");
        ArrayList<Bus> listOfBuses = new ArrayList<>();
        listOfBuses.add(b2);
        listOfBuses.add(b3);
        FileAttenteGenerique.addAll(busFile, listOfBuses);
        System.out.println(busFile);

        //BONUS
        System.out.println("--BONUS--");
        ArrayList<Bus> listOfBuses2 = new ArrayList<>();
        listOfBuses2.add(b4);
        listOfBuses2.add(b5);
        FileAttenteGenerique.addSome(busFile, listOfBuses2);
        System.out.println(busFile);

    }
}

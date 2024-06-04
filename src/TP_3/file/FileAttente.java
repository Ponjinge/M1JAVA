package TP_3.file;

import java.util.ArrayList;

public class FileAttente {

    // Propriétés
    private int capacite;

    private ArrayList<String> elements;

    // Constructeurs
    public FileAttente(int capacite) {
        this.capacite = capacite;
        this.elements = new ArrayList<>(capacite);
    }

    // Ajoute dans la liste d'attente
    public boolean addElement(String auditeur) {
        if (this.capacite == this.elements.size()) {
            return false;
        } else {
            return this.elements.add(auditeur);
        }
    }

    // Enlève le premier élément
    public String removeFirstElement() {
        if (this.elements.isEmpty()) {
            return null;
        }
        return this.elements.removeFirst();
    }

    // Enlève un élément (auditeur qui raccroche)
    public boolean removeElement(String auditeur) {
        return this.elements.remove(auditeur);
    }

    // toString()
    @Override
    public String toString() {
        String ch = "{ ";
        for (String c : this.elements) {
            ch += c + " ";
        }
        ch += "}";
        return ch;
    }

    public static void main(String[] args) {
        // Créer une file d'attentes
        FileAttente f = new FileAttente(3);

        // Ajouter des éléments dans la file et afficher l'état de la file après chaque ajout
        f.addElement("A");
        System.out.println(f);
        f.addElement("B");
        System.out.println(f);
        f.addElement("C");
        System.out.println(f);
        f.addElement("D");
        System.out.println(f);
        // Supprimer l'élément "A" de la liste
        f.removeElement("A");
        System.out.println(f);
        // Supprimer le premier élément de la liste
        f.removeFirstElement();
        System.out.println(f);
    }
}

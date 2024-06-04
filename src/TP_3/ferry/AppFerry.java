package TP_3.ferry;

import java.util.ArrayList;
import java.util.List;

public class AppFerry {

	// Get the number of passengers
	public static int nbP(List<? extends Vehicule> liste){
		int somme = 0;
		for( Vehicule v : liste){
			somme+=v.nbPassagers();

		}
		return somme;
	}


	public static void main(String[] args) {


		//Create a Ferry
		Ferry f = new Ferry(1, 20, 200);

		// Add a parking to the Ferry
		f.addParking(0, new ParkingExterieur(5));


		// Create some Vehicles and add them to the ferry
		Voiture v1 = new Voiture("Voiture01", 2.0, 3.0, 1.75, 1000, 5);
		Bus b1 = new Bus("Bus01", 3000, 3.1, 20.0, 1.5, 60);

		f.ajouterVehicule(v1);
		f.ajouterVehicule(b1);

		System.out.println(f);


		//Cars
		Voiture v2 = new Voiture("Voiture 2",2.2,2.54,1,1100,1);
		Voiture v3 = new Voiture("Voiture 3",2.2,2.54,1,1100,3);
		Voiture v4 = new Voiture("Voiture 4",2.2,2.54,1,1100,4);

		// Buses
		Bus b2 =  new Bus("B2",3500,2.00,21.0,3.5,60);
		Bus b3 =  new Bus("B3",1500,2.30,15.0,3,23);

		//Trucks

		Camion c1 = new Camion("C1", 1200, 2.0, 3.3, 2.3, 30);
		Camion c2 = new Camion("C2", 1104, 2.2, 2.4, 2.7, 10);
		Camion c3 = new Camion("C3", 1000, 2.2, 2.4, 2.4, 10);


		// Create an arraylist of multiple different vehicles
		List<Vehicule> lvh = new ArrayList<Vehicule>();
		lvh.add(b2);
		lvh.add(v2);
		System.out.println("Nombre passagers Vehicule: "+nbP(lvh));


		// Vehicle type specific arraylists

		//Bus
		List<Bus> lb = new ArrayList<>();
		lb.add(b2);
		lb.add(b3);
		System.out.println("Nombre passagers Bus: "+nbP(lb));

		//Car
		List<Voiture> lv = new ArrayList<>();
		lv.add(v2);
		lv.add(v3);
		lv.add(v4);
		System.out.println("Nombre passagers Voiture: "+nbP(lv));

		//Truck
		ArrayList<Camion> lc = new ArrayList<>();
		lc.add(c1);
		lc.add(c2);
		lc.add(c3);
		System.out.println("The Camion array list : " + lc);
		System.out.println("Nombre passagers Camion: "+nbP(lv));

		// Create a ferry with all 3 types of parking
		Ferry ferryTriple = new Ferry(3, 15502, 120);
		ferryTriple.addParking(0, new ParkingExterieur(2));
		// First one IN, First one OUT
		ferryTriple.addParking(1, new Couloir(3, 3));
		// First one IN, Last one OUT
		ferryTriple.addParking(2, new Garage(4, 2.5));

		// Check the status of the ferry
		System.out.println(ferryTriple);


		// Ajouter les véhicules dans le ferry
		ferryTriple.ajouterVehicule(v1);
		ferryTriple.ajouterVehicule(v2);
		ferryTriple.ajouterVehicule(b1);
		ferryTriple.ajouterVehicule(b2);
		ferryTriple.ajouterVehicule(b3);
		ferryTriple.ajouterVehicule(c1);
		ferryTriple.ajouterVehicule(c2);
		ferryTriple.ajouterVehicule(c3);

		// Check the status of the ferry
		System.out.println("Ferry after adding vehicles : ");
		System.out.println(ferryTriple);

		//WILCARD
		// Get the number of passagers for each vehicule type on the ferry
		System.out.println("--TP3 Exercice 5--");
		System.out.println("Nombre de passagers Voiture : "+ferryTriple.getNombrePassagersParType(Voiture.class));
		System.out.println("Nombre de passagers Bus : "+ferryTriple.getNombrePassagersParType(Bus.class));
		System.out.println("Nombre de passagers Camion : "+ferryTriple.getNombrePassagersParType(Camion.class));
		System.out.println("Nombre de passagers de Vehicules : "+ferryTriple.getNombrePassagersParType(Vehicule.class));
		System.out.println("--Fin--");


		// Unload the Ferry
		ferryTriple.dechargement();

		// After Unloading
		System.out.println("Ferry after unloading vehicles :  ");
		System.out.println(ferryTriple);



	}
}

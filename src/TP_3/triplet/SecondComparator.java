package TP_3.triplet;

import java.util.Comparator;

public class SecondComparator<E extends Comparable<E>, F extends Comparable<F>, G extends Comparable<G>> implements Comparator<TripletTypesDifferents<E, F, G>> {
    @Override
    public int compare(TripletTypesDifferents<E, F, G> obj1, TripletTypesDifferents<E, F, G> obj2) {
        return obj1.getSecondObjet().compareTo(obj2.getSecondObjet());
    }
}

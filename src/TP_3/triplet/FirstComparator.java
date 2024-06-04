package TP_3.triplet;

import java.util.Comparator;

public class
FirstComparator<E extends Comparable<E>, F extends Comparable<F>, G extends Comparable<G>> implements Comparator<TripletTypesDifferents<E, F, G>> {
    @Override
    public int compare(TripletTypesDifferents<E, F, G> obj1, TripletTypesDifferents<E, F, G> obj2) {
        return obj1.getFirstObject().compareTo(obj2.getFirstObject());
    }
}

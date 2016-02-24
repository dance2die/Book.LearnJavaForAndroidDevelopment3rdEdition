package collections;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by dance2die on 2/24/2016.
 */

public class CollectionsMain {
    public static void main(String[] args){
        Set<Weekday> daysOff = new TreeSet<Weekday>();
        daysOff.add(Weekday.SUNDAY);
        daysOff.add(Weekday.MONDAY);
        daysOff.add(Weekday.THURSDAY);
        daysOff.add(Weekday.SATURDAY);
        System.out.println(daysOff);
    }
}


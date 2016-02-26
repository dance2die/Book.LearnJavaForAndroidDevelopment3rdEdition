package collections;

import java.util.*;

/**
 * Created by dance2die on 2/24/2016.
 */

public class CollectionsMain {
    public static void main(String[] args){
//        testCollection();
        testArrayDeque();
    }

    private static void testArrayDeque() {
        Deque<String> stack = new ArrayDeque<String>();
        String[] weekdays = { "Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday" };

        for (String weekday: weekdays)
            stack.push(weekday);

        while (stack.peek() != null)
            System.out.println(stack.pop());
    }

    private static void testCollection() {
        Set<Weekday> daysOff = new TreeSet<Weekday>();
        daysOff.add(Weekday.SUNDAY);
        daysOff.add(Weekday.MONDAY);
        daysOff.add(Weekday.THURSDAY);
        daysOff.add(Weekday.SATURDAY);
        System.out.println(daysOff);

        for (Weekday weekday : EnumSet.allOf(Weekday.class)) {
            System.out.println(weekday);
        }
    }
}


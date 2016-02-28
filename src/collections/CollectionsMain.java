package collections;

import java.util.*;

/**
 * Created by dance2die on 2/24/2016.
 */

public class CollectionsMain {
    public static void main(String[] args){
//        testCollection();
//        testArrayDeque();
//        testColorMap();
//        testWeakHashMap();
        testEnumMap();
    }

    private static void testEnumMap() {
        Map<Coin, Integer> map = new EnumMap<Coin, Integer>(Coin.class);
        map.put(Coin.PENNY, 1);
        map.put(Coin.NICKEL, 5);
        map.put(Coin.DIME, 10);
        map.put(Coin.QUARTER, 25);
        System.out.println(map);
        Map<Coin,Integer> mapCopy = new EnumMap<Coin, Integer>(map);
        System.out.println(mapCopy);
    }

    private static void testWeakHashMap() {
        Map<LargeObject, String> map = new WeakHashMap<>();
        LargeObject largeObject = new LargeObject();
        map.put(largeObject, "Large Object");
        System.out.println(map);
        largeObject = null;
        while (!map.isEmpty())
        {
            System.out.println("looping until map is empty");
            new LargeObject();
        }
        System.out.println(map);
    }

    private static void testColorMap() {
        Map<String, Color> colorMap = new TreeMap<>();
        colorMap.put("red", Color.RED);
        colorMap.put("blue", Color.BLUE);
        colorMap.put("green", Color.GREEN);
        colorMap.put("RED", Color.RED);

        for (String colorKey: colorMap.keySet()) {
            System.out.println(colorKey);
        }

        Collection<Color> colorValues = colorMap.values();
        for (Color colorValue : colorValues) {
            System.out.println(colorValue);
        }
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


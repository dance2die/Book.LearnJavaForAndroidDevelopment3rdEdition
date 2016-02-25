package collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueMain
{
    final static int ELEMENT_COUNT = 15;

    public static void main(String[] args)
    {
        Queue<Integer> qi = new PriorityQueue<>(ELEMENT_COUNT, (e1, e2) -> e2 - e1);

        for (int i = 0; i < ELEMENT_COUNT; i++) {
            qi.add((int) (Math.random() * 100));
        }

        while (!qi.isEmpty()) {
            System.out.print(qi.poll() + " ");
        }

        System.out.println();
    }
}
package hr_manager;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ProgTest
{
    private final int count = 100_000;

    @Test
    public void testCustomSortOrderValidity()
    {
        Random random = new Random();
        Integer[] array = new Integer[count];

        for (int i = 0; i < count; i++)
        {
            array[i] = random.nextInt();
        }

        Prog.customSort(array);

        for (int i = 1; i < count; i++)
        {
            assertTrue(array[i - 1] <= array[i]);
        }
    }

    @Test
    public void testCustomSortItemsValidity()
    {
        class Pair implements Comparable<Pair>
        {
            private final int uniqueID, value;

            public Pair(int ID, int value) { uniqueID = ID; this.value = value; }
            public int getUniqueID() { return uniqueID; }
            public int getValue() { return value; }
            @Override
            public int compareTo(Pair other) { return Integer.compare(value, other.getValue()); }
        }

        Random random = new Random();
        Pair[] array = new Pair[count];
        Set<Pair> hashset = new HashSet<>();

        for (int i = 0; i < count; i++)
        {
            array[i] = new Pair(i, random.nextInt());
            hashset.add(array[i]);
        }

        Prog.customSort(array);

        for (int i = 0; i < count; i++)
        {
            assertTrue(hashset.contains(array[i]));
        }
    }
}
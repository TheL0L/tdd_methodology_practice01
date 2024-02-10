package hr_manager;

import java.util.Arrays;

public class Prog
{
    public static void main(String[] args)
    {
        final int count = 1_000;
        Worker[] workers = WorkerGenerator.generateWorkers(count);

        long startTime = System.currentTimeMillis();
        var arr = customSort(workers);
        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;
        System.out.println("Execution Time: " + executionTime + "ms.");
    }

    public static <T extends Comparable<T>> T[] customSort(T[] array) {
        int n = array.length;
        T[] sortedArray = Arrays.copyOf(array, n);
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (sortedArray[i - 1].compareTo(sortedArray[i]) > 0) {
                    // Swap elements if they are in the wrong order
                    T temp = sortedArray[i - 1];
                    sortedArray[i - 1] = sortedArray[i];
                    sortedArray[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);

        return sortedArray;
    }
}

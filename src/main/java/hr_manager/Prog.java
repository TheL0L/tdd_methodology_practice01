package hr_manager;

import java.util.function.Supplier;

public class Prog
{
    public static void main(String[] args)
    {
        final int count = 10_000;
        Worker[] workers = WorkerGenerator.generateWorkers(count);

        long startTime = System.currentTimeMillis();
        customSort(workers);
        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;
        System.out.println("Execution Time: " + executionTime + "ms.");
    }

    public static <T extends Comparable<T>> void customSort(T[] array) {
        int n = array.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1].compareTo(array[i]) > 0) {
                    // Swap elements if they are in the wrong order
                    T temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}

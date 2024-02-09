package hr_manager;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class WorkerGeneratorTest
{
    private final int count = 100_000;
    @Test
    public void testGenerateWorkersWageValidity()
    {
        Worker[] workers = WorkerGenerator.generateWorkers(count);

        for (Worker worker : workers)
        {
            assertTrue(worker.getWage() >= 3_000);
            assertTrue(worker.getWage() <= 15_000);
        }
    }

    @Test
    public void testGenerateWorkersIdUniqueness()
    {
        Set<Integer> usedIds = new HashSet<>();

        Worker[] workers = WorkerGenerator.generateWorkers(count);

        for (Worker worker : workers)
        {
            assertFalse(usedIds.contains(worker.getId()));

            usedIds.add(worker.getId());
        }
    }

    @Test
    public void testGenerateWorkersPhoneUniqueness()
    {
        Set<String> usedPhones = new HashSet<>();

        Worker[] workers = WorkerGenerator.generateWorkers(count);

        for (Worker worker : workers)
        {
            assertFalse(usedPhones.contains(worker.getPhone()));

            usedPhones.add(worker.getPhone());
        }
    }

    @Test
    public void testGenerateWorkersEmailUniqueness()
    {
        Set<String> usedEmails = new HashSet<>();

        Worker[] workers = WorkerGenerator.generateWorkers(count);

        for (Worker worker : workers)
        {
            assertFalse(usedEmails.contains(worker.getEmail()));

            usedEmails.add(worker.getEmail());
        }
    }
}
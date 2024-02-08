package hr_manager;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProgTest
{
    @Test
    public void testAddInt()
    {
        int x = 5, y = 5;

        assertEquals(x + y, Prog.AddInt(x, y));
    }
}
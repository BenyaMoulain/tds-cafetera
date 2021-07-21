package cl.benjamin.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DrinkTest {
    
    private Drink drink;

    @Before
    public void setUp() {
        drink = new Drink("cafe", 100, 10, 0, 0, 3);
    }

    @Test
    public void testDrinkGetters() {
        assertEquals("Drink name is not equal", "cafee", drink.getName());
        assertEquals(100, drink.getPrice(), 0);
        assertEquals(10, drink.getCoffee(), 0);
        assertEquals(0, drink.getChocolate(), 0);
        assertEquals(0, drink.getMilk(), 0);
        assertEquals(3, drink.getSugar(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckQuantities() {
        new Drink("cafe cargado", 100, 1000, 0, 0, 0);
    }
}

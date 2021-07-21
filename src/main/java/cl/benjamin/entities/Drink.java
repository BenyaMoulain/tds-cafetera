package cl.benjamin.entities;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Drink {
    private static final String SUGAR_EXCEED_MESSAGE = "The sugar quantity is over the limit.";
    private static final String MILK_EXCEED_MESSAGE = "The milk quantity is over the limit.";
    private static final String CHOCOLATE_EXCEED_MESSAGE = "The chocolate quantity is over the limit.";
    private static final String COFFEE_EXCEED_MESSAGE = "The coffee quantity is over the limit.";
    private static final int MAX_COFFEE = 10;
    private static final int MAX_CHOCOLATE = 10;
    private static final int MAX_MILK = 80;
    private static final int MAX_SUGAR = 40;
    
    private String name;
    private int price;
    private int coffee;
    private int chocolate;
    private int milk;
    private int sugar;
     private static Logger logger = Logger.getLogger(Drink.class.getName());

    public Drink(String name, int price, int coffee, int chocolate, int milk, int sugar) {
        checkQuantities(coffee, chocolate, milk, sugar);
        this.name = name;
        this.price = price;
        this.coffee = coffee;
        this.chocolate = chocolate;
        this.milk = milk;
        this.sugar = sugar;
    }

    private void checkQuantities(int coffee, int chocolate, int milk, int sugar) {
        if (coffee > MAX_COFFEE) {
            logger.log(Level.SEVERE, COFFEE_EXCEED_MESSAGE);
            throw new IllegalArgumentException(COFFEE_EXCEED_MESSAGE);
        }
        if (chocolate > MAX_CHOCOLATE) {
            logger.log(Level.SEVERE, CHOCOLATE_EXCEED_MESSAGE);
            throw new IllegalArgumentException(CHOCOLATE_EXCEED_MESSAGE);
        }
        if (milk > MAX_MILK) {
            logger.log(Level.SEVERE, MILK_EXCEED_MESSAGE);
            throw new IllegalArgumentException(MILK_EXCEED_MESSAGE);
        }
        if (sugar > MAX_SUGAR) {
            logger.log(Level.SEVERE, SUGAR_EXCEED_MESSAGE);
            throw new IllegalArgumentException(SUGAR_EXCEED_MESSAGE);
        }
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCoffee() {
        return coffee;
    }
    
    public int getChocolate() {
        return chocolate;
    }

    public int getMilk() {
        return milk;
    }
    
    public int getSugar() {
        return sugar;
    }
}

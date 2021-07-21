package cl.benjamin.entities;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Drink {
    private String name;
    private int price;
    private int coffee;
    private int chocolate;
    private int milk;
    private int sugar;
    private int MAX_COFFEE = 10;
    private int MAX_CHOCOLATE = 10;
    private int MAX_MILK = 80;
    private int MAX_SUGAR = 40;
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
            logger.log(Level.SEVERE, "The coffee quantity is over the limit.");
            throw new IllegalArgumentException("The coffee quantity is over the limit.");
        }
        if (chocolate > MAX_CHOCOLATE) {
            logger.log(Level.SEVERE, "The chocolate quantity is over the limit.");
            throw new IllegalArgumentException("The chocolate quantity is over the limit.");
        }
        if (milk > MAX_MILK) {
            logger.log(Level.SEVERE, "The milk quantity is over the limit.");
            throw new IllegalArgumentException("The milk quantity is over the limit.");
        }
        if (sugar > MAX_SUGAR) {
            logger.log(Level.SEVERE, "The sugar quantity is over the limit.");
            throw new IllegalArgumentException("The sugar quantity is over the limit.");
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

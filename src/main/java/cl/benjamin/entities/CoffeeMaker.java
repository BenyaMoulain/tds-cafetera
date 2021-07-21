package cl.benjamin.entities;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CoffeeMaker {

    private Inventory inventory;
    private Drink[] drinks;
    private int cash = 0;
    private static Logger logger = Logger.getLogger(CoffeeMaker.class.getName());

    public CoffeeMaker(Inventory inventory, Drink[] drinks) {
        this.inventory = inventory;
        this.drinks = drinks;
    }

    public void makeDrink(int coffeeQty, int chocolateQty, int milkQty, int sugarQty) {
        if (inventory.checkRecipeIngredients(coffeeQty, chocolateQty, milkQty, sugarQty)) {
            removeIngredients(coffeeQty, chocolateQty, milkQty, sugarQty);
        }
    }

    private void removeIngredients(int coffeeQty, int chocolateQty, int milkQty, int sugarQty) {
        logger.log(Level.INFO, "Removing ingredients from inventory");
        inventory.removeCoffee(coffeeQty);
        inventory.removeChocolate(chocolateQty);
        inventory.removeMilk(milkQty);
        inventory.removeSugar(sugarQty);
    }

    public void addCash (int amount) {
        logger.log(Level.INFO, "Adding cash: {0}", amount);
        cash += amount;
        logger.log(Level.INFO, "Total cash after adding: {0}", cash);
    }

    public void removeCash (int amount) {
        logger.log(Level.INFO, "Removing cash: {0}", amount);
        cash -= amount;
    }

    public int getCash () {
        return cash;
    }

    public void returnCash () {
        logger.log(Level.INFO, "Returning change cash to client");
        System.out.println("Your change: " + cash);
        cash = 0;
    }

    public void showDrinks () {
        logger.log(Level.INFO, "Showing available drinks");
        System.out.println("Drinks: ");
        for (Drink drink : drinks) {
            System.out.println(drink.getName() + ": " + drink.getPrice());
        }
    }

    public void buyDrink (String name) {
        for (Drink drink : drinks) {
            if (drink.getName().equals(name)) {
                logger.log(Level.INFO, "Attemp to buy drink: {0}", drink.getName());
                int price = drink.getPrice();
                int coffeeQty = drink.getCoffee();
                int chocolateQty = drink.getChocolate();
                int milkQty = drink.getMilk();
                int sugarQty = drink.getSugar();
                boolean areEnoughIngredients = inventory.checkRecipeIngredients(coffeeQty, chocolateQty, milkQty, sugarQty);
                if (cash >= price) {
                    if (areEnoughIngredients) {
                        logger.log(Level.INFO, "Drink can be bought");
                        removeIngredients(coffeeQty, chocolateQty, milkQty, sugarQty);
                        removeCash(price);
                        returnCash();
                        logger.log(Level.INFO, "Drink bought");
                        System.out.println("Su bebida " + drink.getName() + " esta lista");
                    } else {
                        logger.log(Level.INFO, "Not enough ingredients for {0}", drink.getName());
                        System.out.println("Not enough ingredients :(");
                    }
                } else {
                    logger.log(Level.INFO, "Not enough cash for {0}", drink.getName());
                    System.out.println("Not enough cash :(");
                }
            }
        }
    }
}

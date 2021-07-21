package cl.benjamin.entities;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Inventory {
    private int coffee = 0;
    private int chocolate = 0;
    private int milk = 0;
    private int sugar = 0;
    private static Logger logger = Logger.getLogger(Inventory.class.getName());

    public void addCoffee(int n) {
        if (n > 0) {
            logger.log(Level.INFO, "adding {0} units of coffee", n);
            coffee += n;
        }
    }

    public void addChocolate(int n) {
        if (n > 0) {
            logger.log(Level.INFO, "adding {0} units of chocolate", n);
            chocolate += n;
        }
    }

    public void addMilk(int n) {
        if (n > 0) {
            logger.log(Level.INFO, "adding {0} units of milk", n);
            milk += n;
        }
    }

    public void addSugar(int n) {
        if (n > 0) {
            logger.log(Level.INFO, "adding {0} units of sugar", n);
            sugar += n;
        }
    }

    public void removeCoffee(int n) {
        if (n > 0) {
            logger.log(Level.INFO, "removing {0} units of coffee", n);
            coffee -= n;
        }
    }

    public void removeChocolate(int n) {
        if (n > 0) {
            logger.log(Level.INFO, "removing {0} units of chocolate", n);
            chocolate -= n;
        }
    }

    public void removeMilk(int n) {
        if (n > 0) {
            logger.log(Level.INFO, "removing {0} units of milk", n);
            milk -= n;
        }
    }

    public void removeSugar(int n) {
        if (n > 0) {
            logger.log(Level.INFO, "removing {0} units of sugar", n);
            sugar -= n;
        }
    }

    public boolean checkRecipeIngredients(int coffeeQty, int chocolateQty, int milkQty, int sugarQty) {
        return (coffee - coffeeQty >= 0 && chocolate - chocolateQty >= 0 && milk - milkQty >= 0 && sugar - sugarQty >= 0);
    }

    public void showInventory() {
        System.out.println("Coffee: " + coffee);
        System.out.println("Chocolate: " + chocolate);
        System.out.println("Milk: " + milk);
        System.out.println("Sugar: " + sugar);
    }
}

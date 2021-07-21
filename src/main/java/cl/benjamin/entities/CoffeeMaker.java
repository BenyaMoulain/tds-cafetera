package cl.benjamin.entities;

public class CoffeeMaker {

    private Inventory inventory;
    private Drink[] drinks;
    private int cash = 0;

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
        inventory.removeCoffee(coffeeQty);
        inventory.removeChocolate(chocolateQty);
        inventory.removeMilk(milkQty);
        inventory.removeSugar(sugarQty);
    }

    public void addCash (int amount) {
        cash += amount;
    }

    public void removeCash (int amount) {
        cash -= amount;
    }

    public int getCash () {
        return cash;
    }

    public void returnCash () {
        // print cash to console
        System.out.println("Your change: " + cash);
        cash = 0;
    }

    public void showDrinks () {
        System.out.println("Drinks: ");
        for (Drink drink : drinks) {
            System.out.println(drink.getName() + ": " + drink.getPrice());
        }
    }

    public void buyDrink (String name) {
        for (Drink drink : drinks) {
            if (drink.getName().equals(name)) {
                int price = drink.getPrice();
                int coffeeQty = drink.getCoffee();
                int chocolateQty = drink.getChocolate();
                int milkQty = drink.getMilk();
                int sugarQty = drink.getSugar();
                boolean areEnoughIngredients = inventory.checkRecipeIngredients(coffeeQty, chocolateQty, milkQty, sugarQty);
                if (cash >= price) {
                    if (areEnoughIngredients) {
                        removeIngredients(coffeeQty, chocolateQty, milkQty, sugarQty);
                        removeCash(price);
                        returnCash();
                        System.out.println("Su bebida " + drink.getName() + "esta lista");
                    } else {
                        System.out.println("Not enough ingredients :(");
                    }
                } else {
                    System.out.println("Not enough money :(");
                }
            }
        }
    }
}

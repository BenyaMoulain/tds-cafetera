package cl.benjamin.helpers;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import cl.benjamin.entities.CoffeeMaker;
import cl.benjamin.entities.Inventory;

public final class Actions {
    private Actions () {}
    private static Logger logger = Logger.getLogger(Actions.class.getName());

    public static void addIngredientsToInventory(Inventory inventory) {
        askForIngredientToAdd(inventory, "coffee");
        askForIngredientToAdd(inventory, "chocolate");
        askForIngredientToAdd(inventory, "milk");
        askForIngredientToAdd(inventory, "sugar");
    }

    private static void askForIngredientToAdd(Inventory inventory, String ingredient) {
        int quantity = -1;
        String input;
        while(quantity < 0) {
            System.out.println("how much " + ingredient + " do you want to add?");
            input = new Scanner(System.in).nextLine();
            try {
                quantity = Integer.parseInt(input);
                switch (ingredient) {
                    case "coffee":
                        inventory.addCoffee(quantity);
                        break;
                    case "chocolate":
                        inventory.addChocolate(quantity);
                        break;
                    case "milk":
                        inventory.addMilk(quantity);
                        break;
                    case "sugar":
                        inventory.addSugar(quantity);
                        break;
                    default:
                        logger.log(Level.SEVERE, "unknown ingredient");
                        break;
                }
            } catch (NumberFormatException e) {
                logger.log(Level.INFO, "NumberFormatException Error: {0}", e.getMessage());
                System.out.println("please enter a number");
            }
        }
    }

    public static void showInventory(Inventory inventory) {
        inventory.showInventory();
    }

    
    public static void sellRecipe(CoffeeMaker coffeeMaker) {
        System.out.println("how much cash do you want to add?");
        Scanner amountScanner = new Scanner(new InputStreamReader(System.in));
        Scanner drinkScanner =new Scanner(new InputStreamReader(System.in, StandardCharsets.ISO_8859_1));
        try {
            int amount = amountScanner.nextInt();
            if (amount > 0) {
                coffeeMaker.addCash(amount);
            } else {
                System.out.println("please enter a positive number");
            }
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, "NumberFormatException Error: {0}", e.getMessage());
            System.out.println("please enter a number");
        } catch (InputMismatchException e) {
            logger.log(Level.WARNING, "InputMismatchException Error: {0}", e.getMessage());
            System.out.println("please enter a integer number");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error: {0}", e.getMessage());
            System.out.println("something went wrong");
        }
        if (coffeeMaker.getCash() > 0) {
            coffeeMaker.showDrinks();
            System.out.println("please enter a drink name: ");
            String drinkName = drinkScanner.nextLine();
            coffeeMaker.buyDrink(drinkName);
        }
    }
}

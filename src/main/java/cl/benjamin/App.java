package cl.benjamin;

import java.util.Scanner;

import cl.benjamin.entities.CoffeeMaker;
import cl.benjamin.entities.Drink;
import cl.benjamin.entities.Inventory;
import cl.benjamin.helpers.Actions;
import cl.benjamin.helpers.RecipeReader;

public class App 
{
        private static Inventory inventory = new Inventory();
        private static Drink[] drinks = RecipeReader.execute("recipes.json");
        private static CoffeeMaker machine = new CoffeeMaker(inventory, drinks);
        public static void main(String[] args) {
            

        while (true) {
            String option = "";
            while (!option.equals("1") && !option.equals("2") && !option.equals("3")) {
                System.out.println("1. Add item to inventory");
                System.out.println("2. Show inventory");
                System.out.println("3. Buy drink");
                option = new Scanner(System.in).nextLine();
            }
            if (option.equals("1")) {
                Actions.addIngredientsToInventory(inventory);
            }
            else if (option.equals("2")) {
                Actions.showInventory(inventory);
            }
            else if (option.equals("3")) {
                Actions.sellRecipe(machine);
            }
        }
    }

}

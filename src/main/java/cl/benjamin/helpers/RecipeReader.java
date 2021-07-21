package cl.benjamin.helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import cl.benjamin.entities.Drink;

public final class RecipeReader 
{   
    private RecipeReader() { }

    public static Drink[] execute(String fileName)  
    {
        Drink[] drinks = new Drink[3];
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileName))
        {
            Object obj = jsonParser.parse(reader); 
            JSONArray recipeList = (JSONArray) obj;             
            for (int i = 0; i < 3; i++)
            {
                drinks[i] = parseRecipe((JSONObject) recipeList.get(i));
            }            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return drinks;
    }
 
    private static Drink parseRecipe(JSONObject recipe) 
    {         
        String name = (String) recipe.get("name");    
        int price = Integer.parseInt(Long.toString((Long) recipe.get("price"))); 
        int coffee = Integer.parseInt(Long.toString((Long) recipe.get("coffee"))); 
        int chocolate = Integer.parseInt(Long.toString((Long) recipe.get("chocolate")));
        int milk = Integer.parseInt(Long.toString((Long) recipe.get("milk")));
        int sugar = Integer.parseInt(Long.toString((Long) recipe.get("sugar")));
        return new Drink(name, price, coffee, chocolate, milk, sugar);
    }
}

package cl.benjamin.entities;

public class Drink {
    private String name;
    private int price;
    private int coffee;
    private int chocolate;
    private int milk;
    private int sugar;

    public Drink(String name, int price, int coffee, int chocolate, int milk, int sugar) {
        this.name = name;
        this.price = price;
        this.coffee = coffee;
        this.chocolate = chocolate;
        this.milk = milk;
        this.sugar = sugar;
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

    public String toString() {
        return name + " " + price + " " + coffee + " " + chocolate + " " + milk + " " + sugar;
    }
}

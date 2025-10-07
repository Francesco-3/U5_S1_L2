package francescodicecca.CommandLineRunner.entities;

import java.util.List;

public class Menu {
    private final List<Pizza> pizzas;
    private final List<Topping> toppings;
    private final List<Drink> drinks;

    public Menu(List<Pizza> pizzas, List<Topping> toppings, List<Drink> drinks) {
        this.pizzas = pizzas;
        this.toppings = toppings;
        this.drinks = drinks;
    }

    public void printMenu() {
        System.out.printf("\n%-60s %10s %15s\n", "Pizza", "Calories", "Price");
        pizzas.forEach(Pizza::print);
        System.out.println();

        System.out.printf("%-60s %10s %15s\n", "Toppings", "Calories", "Price");
        toppings.forEach(Topping::print);
        System.out.println();

        System.out.printf("%-60s %10s %15s\n", "Drinks", "Calories", "Price");
        drinks.forEach(Drink::print);
        System.out.println();
    }

    public static class Pizza extends Item {
        private final String ingredients;

        public Pizza(String name, String ingredients, int calories, double price) { super(name, calories, price); this.ingredients = ingredients; }

        @Override
        public void print() { System.out.printf("%-60s %10s %15s\n", name + " (" + ingredients + ")", calories, price); }
    }
}

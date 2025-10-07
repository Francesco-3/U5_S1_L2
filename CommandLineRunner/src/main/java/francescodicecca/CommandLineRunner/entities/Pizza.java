package francescodicecca.CommandLineRunner.entities;

public class Pizza extends Item {
    private final String ingredients;

    public Pizza(String name, String ingredients, int calories, double price) { super(name, calories, price); this.ingredients = ingredients; }

    @Override
    public void print() { System.out.printf("%-60s %10s %15s\n", name + " (" + ingredients + ")", calories, price); }
}

package francescodicecca.CommandLineRunner.entities;

public class Topping extends Item {
    public Topping(String name, int calories, double price) { super(name, calories, price); }

    @Override
    public void print() { System.out.printf("%-60s %10s %15s\n", name, calories, price); }
}

package francescodicecca.CommandLineRunner.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Item {
    protected String name;
    protected int calories;
    protected double price;

    public abstract void print();
}

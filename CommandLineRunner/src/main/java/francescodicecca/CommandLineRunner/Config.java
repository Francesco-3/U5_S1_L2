package francescodicecca.CommandLineRunner;

import francescodicecca.CommandLineRunner.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class Config {

    // Pizzas
    @Bean
    public Menu.Pizza margheritaPizza() {
        return new Menu.Pizza("Pizza Margherita", "tomato, cheese", 1104, 4.99);
    }

    @Bean
    public Menu.Pizza hawaiianPizza() {
        return new Menu.Pizza("Hawaiian Pizza", "tomato, cheese, ham, pineapple", 1024, 6.49);
    }

    @Bean
    public Menu.Pizza salamiPizza() {
        return new Menu.Pizza("Salami Pizza", "tomato, cheese, salami", 1160, 5.99);
    }

    // Toppings
    @Bean
    public Topping cheese() {
        return new Topping("Cheese", 92, 0.69);
    }

    @Bean
    public Topping ham() {
        return new Topping("Ham", 35, 0.99);
    }

    @Bean
    public Topping onions() {
        return new Topping("Onions", 22, 0.69);
    }

    @Bean
    public Topping pineapple() {
        return new Topping("Pineapple", 24, 0.79);
    }

    @Bean
    public Topping salami() {
        return new Topping("Salami", 86, 0.99);
    }

    // Drinks
    @Bean
    public Drink lemonade() {
        return new Drink("Lemonade (0.33l)", 128, 1.29);
    }

    @Bean
    public Drink water() {
        return new Drink("Water (0.5l)", 0, 1.29);
    }

    @Bean
    public Drink wine() {
        return new Drink("Wine (0.75l, 13%)", 607, 7.49);
    }

    // Menu
    @Bean
    public Menu menu(Menu.Pizza margheritaPizza, Menu.Pizza hawaiianPizza, Menu.Pizza salamiPizza,
                     Topping cheese, Topping ham, Topping onions, Topping pineapple, Topping salami,
                     Drink lemonade, Drink water, Drink wine) {
        return new Menu(
                List.of(margheritaPizza, hawaiianPizza, salamiPizza),
                List.of(cheese, ham, onions, pineapple, salami),
                List.of(lemonade, water, wine)
        );
    }
}

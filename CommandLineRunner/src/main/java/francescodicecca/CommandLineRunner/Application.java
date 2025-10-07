package francescodicecca.CommandLineRunner;

import francescodicecca.CommandLineRunner.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner{
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    private final ApplicationContext context;

    public Application(ApplicationContext context) {
        this.context = context;
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        Menu menu = context.getBean(Menu.class);
        menu.printMenu();

        CommandService commandService = context.getBean(CommandService.class);

        Desk desk = new Desk(5, 4, DeskState.FREE);

        List<Item> element = List.of(
                context.getBean("margheritaPizza", Menu.Pizza.class),
                context.getBean("lemonade", Drink.class),
                context.getBean("cheese", Topping.class)
        );

        Command command = commandService.makeCommand(element, desk, 2);

        logger.info("\n{}", command);
    }
}

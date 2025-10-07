package francescodicecca.CommandLineRunner.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CommandService {
    @Value("${restaurant.cost.seat}")
    private double seatCost;

    private static final AtomicInteger commandCount = new AtomicInteger(1);

    public Command makeCommand(List<Item> element, Desk desk, int seats) {
        desk.setState(DeskState.BUSY);

        return new Command(
                commandCount.getAndIncrement(),
                CommandState.IN_PROGRESS,
                seats,
                LocalDateTime.now(),
                element,
                desk,
                seatCost
        );
    }
}

package francescodicecca.CommandLineRunner.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Desk {
    private int number;
    private int maxSeats;
    private DeskState state;
}

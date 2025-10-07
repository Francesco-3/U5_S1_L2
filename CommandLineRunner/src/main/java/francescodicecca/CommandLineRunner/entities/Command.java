package francescodicecca.CommandLineRunner.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Command {
    private int commandNumber;
    private CommandState state;
    private int seatsNumber;
    private LocalDateTime acquisitionTime;
    private List<Item> element;
    private Desk desk;
    private double seatCost;
    private double total;

    public Command(int commandNumber, CommandState state, int seatsNumber,
                  LocalDateTime acquisitionTime, List<Item> element,
                  Desk desk, double seatCost) {
        this.commandNumber = commandNumber;
        this.state = state;
        this.seatsNumber = seatsNumber;
        this.acquisitionTime = acquisitionTime;
        this.element = element;
        this.desk = desk;
        this.seatCost = seatCost;
        this.total = sumTotal();
    }

    private double sumTotal() {
        double totalItems = element.stream()
                .mapToDouble(Item::getPrice)
                .sum();
        return totalItems + (seatsNumber * seatCost);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ordine n°").append(commandNumber).append(" - Stato: ").append(state).append("\n")
                .append("Tavolo: ").append(desk.getNumber()).append(" - Coperti: ").append(seatsNumber).append("\n")
                .append("Ora: ").append(acquisitionTime).append("\n")
                .append("Elementi:\n");
        element.forEach(item -> sb.append(" - ").append(item.getName()).append(" (€").append(item.getPrice()).append(")\n"));
        sb.append("Costo Coperto: €").append(seatCost).append(" x ").append(seatsNumber).append("\n")
                .append("Totale: €").append(String.format("%.2f", total));
        return sb.toString();
    }
}

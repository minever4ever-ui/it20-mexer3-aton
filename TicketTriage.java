import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Ticket {
    String name;
    int urgency;
    int arrivalOrder;

    public Ticket(String name, int urgency, int arrivalOrder) {
        this.name = name;
        this.urgency = urgency;
        this.arrivalOrder = arrivalOrder;
    }
}

public class TicketTriage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Ticket> queue = new PriorityQueue<>(
            Comparator.comparingInt((Ticket t) -> t.urgency)
                      .thenComparingInt(t -> t.arrivalOrder)
        );

        System.out.println("Enter 3 help-desk tickets:");
       
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nTicket " + i);

            System.out.print("Enter ticket name: ");
            String name = sc.nextLine();

            System.out.print("Enter urgency number: ");
            int urgency = sc.nextInt();
            sc.nextLine();

            queue.offer(new Ticket(name, urgency, i));
        }

        System.out.println("\nExpected poll order:");

        while (!queue.isEmpty()) {
            Ticket ticket = queue.poll();
            System.out.println(ticket.name);
        }

        sc.close();
    }
}
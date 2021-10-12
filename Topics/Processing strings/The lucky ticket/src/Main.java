import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ticket = scanner.nextLine();
        String[] ticketParts = ticket.split("");

        if (Integer.parseInt(ticketParts[0]) + Integer.parseInt(ticketParts[1]) + Integer.parseInt(ticketParts[2])
                == Integer.parseInt(ticketParts[3]) + Integer.parseInt(ticketParts[4]) + Integer.parseInt(ticketParts[5])) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}
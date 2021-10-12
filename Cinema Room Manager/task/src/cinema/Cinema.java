package cinema;

import java.util.Scanner;

public class Cinema {
    private static int seats;
    private static int rows;
    private static String[][] plan;
    private static float income;
    private static float totalIncome;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        setCinemaPlan();
        menu();
    }

    private static void setCinemaPlan() {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();
        plan = new String[rows + 1][seats + 1];

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {

                if (i == 0 && j == 0) {
                    plan[i][j] = " ";
                } else if (i == 0) {
                    plan[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    plan[i][j] = String.valueOf(i);
                } else {
                    plan[i][j] = "S";
                }
            }
        }
    }

    private static void menu() {
        String option1 = "1. Show the seats";
        String option2 = "2. Buy a ticket";
        String option3 = "3. Statistics";
        String option0 = "0. Exit";
        System.out.println("");
        System.out.println(option1);
        System.out.println(option2);
        System.out.println(option3);
        System.out.println(option0);

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                printPlan(rows, seats, plan);
                menu();
                break;
            case 2:
                buyTicket();
                menu();
                break;
            case 3:
                statistics();
                menu();
            case 0:
                return;
            default:
                System.out.println("This option is not available\\n");
                menu();
        }
    }

    private static void buyTicket() {
        int ticketPrice;

        System.out.println("");
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();

        if (rowNumber <= 0 || rowNumber > rows || seatNumber <= 0 || seatNumber > seats) {
            System.out.println("Wrong input!");
            buyTicket();

        } else if (plan[rowNumber][seatNumber] == "B") {
            System.out.println("That ticket has already been purchased!");
            buyTicket();

        } else {
            if (rows * seats < 60) {
                ticketPrice = 10;
            } else if (rowNumber <= rows / 2) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
            System.out.println("");
            System.out.println("Ticket price: $" + ticketPrice);
            plan[rowNumber][seatNumber] = "B";
            income += ticketPrice;
        }
    }

    private static void printPlan(int rows, int seats, String[][] plan) {
        System.out.println("");
        System.out.println("Cinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                System.out.print(plan[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static void statistics() {
        float cinemaSize = rows * seats;
        int soldTickets = countSoldTickets();
        float percentage = (100 * soldTickets) / cinemaSize;

        if (rows * seats < 60) {
            totalIncome = rows * seats * 10;
        } else {
            int rowsPremium = rows / 2;
            int rowsCheap = rows - rowsPremium;
            totalIncome = (rowsPremium * seats * 10) + (rowsCheap * seats * 8);
        }

        System.out.println("");
        System.out.println("Number of purchased tickets: " + soldTickets);
        System.out.printf("Percentage: %.2f", percentage);
        System.out.println("%");
        System.out.printf("Current income: $%.0f \n", income);
        System.out.printf("Total income: $%.0f \n", totalIncome);
    }

    private static int countSoldTickets() {
        int soldTickets = 0;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (plan[i][j] == "B") {
                    soldTickets++;
                }
            }
        }
        return soldTickets;
    }
}
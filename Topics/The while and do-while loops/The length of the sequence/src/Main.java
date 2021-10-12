import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = -1;
        int number;

        do {
            number = scanner.nextInt();
            length += 1;
        } while (number != 0);

        System.out.println(length);
    }
}
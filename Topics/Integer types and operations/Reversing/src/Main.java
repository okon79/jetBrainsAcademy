import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int pos3 = number / 100;
        int pos2 = (number % 100) / 10;
        int pos1 = (number % 100) % 10;
        int revNumber = pos3 + pos2 * 10 + pos1 * 100;

        System.out.println(revNumber);
    }
}
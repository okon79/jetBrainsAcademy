import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int first = number / 100;
        int second = (number % 100) / 10;
        int third = (number % 100) % 10;

        int sum = first + second + third;
        System.out.println(sum);
    }
}
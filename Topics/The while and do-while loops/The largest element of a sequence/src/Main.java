import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int item;
        int largest = 0;

        do {
            item = scanner.nextInt();
            if (item > largest) {
                largest = item;
            }
        } while (item != 0);

        System.out.println(largest);
    }
}
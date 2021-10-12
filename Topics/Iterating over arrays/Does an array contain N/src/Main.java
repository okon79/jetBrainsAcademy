import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] tab = new int[size];

        for (int i = 0; i < size; i++) {
            tab[i] = scanner.nextInt();
        }

        int number = scanner.nextInt();
        boolean result = false;

        for (int item: tab) {
            if (item == number) {
                result = true;
                break;
            }
        }
        System.out.println(result);
    }
}
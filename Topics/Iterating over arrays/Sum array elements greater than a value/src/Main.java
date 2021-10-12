import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] tab = new int[size];
        int sum = 0;

        for (int i = 0; i < size; i++) {
            tab[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();

        for (int num: tab) {
            if (num > n) {
                sum += num;
            }
        }

        System.out.println(sum);
    }
}
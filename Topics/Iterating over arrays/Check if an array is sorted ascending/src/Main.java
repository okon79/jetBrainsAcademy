import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] tab = new int[size];

        for (int i = 0; i < size; i++) {
            tab[i] = scanner.nextInt();
        }

        boolean sorted = true;
        for (int i = 1; i < tab.length; i++) {
            if (tab[i] >= tab[i - 1]) {
                sorted = true;
            } else {
                sorted = false;
                break;
            }
        }
        System.out.println(sorted);
    }
}
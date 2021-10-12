import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String[][] table = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = ".";

                if (i == size / 2 || j == size / 2 || i == j || i + j == size - 1) {
                    table[i][j] = "*";
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
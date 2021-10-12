import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int l = input.length();

        if (l % 2 == 0) {
            int index = l / 2;
            for (int i = 0; i < l; i++) {
                System.out.print(i != index && i != index - 1 ? input.charAt(i) : "");
            }
        } else {
            int index = l / 2 + 1;
            for (int i = 0; i < l; i++) {
                System.out.print(i != index - 1 ? input.charAt(i) : "");
            }
        }
    }
}
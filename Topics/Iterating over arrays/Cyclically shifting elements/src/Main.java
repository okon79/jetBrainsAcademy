import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] a = new int[length];
        int buffer;

        for (int i = 0; i < length; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < (a.length - 1); i++) {
            buffer = a[i + 1];
            a[i + 1] = a[0];
            a[0] = buffer;
        }

        for (int elem: a) {
            System.out.print(elem + " ");
        }
    }
}
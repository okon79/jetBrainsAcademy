import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int units = scanner.nextInt();

        if (units < 1) {
            System.out.println("no army");
        } else if (units >= 1 && units < 20) {
            System.out.println("pack");
        } else if (units >= 20 && units < 250) {
            System.out.println("throng");
        } else if (units >= 250 && units < 1000) {
            System.out.println("zounds");
        } else {
            System.out.println("legion");
        }
    }
}
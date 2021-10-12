import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        boolean res1 = num1 > 0 && !(num2 > 0) && !(num3 > 0);
        boolean res2 = !(num1 > 0) && num2 > 0 && !(num3 > 0);
        boolean res3 = !(num1 > 0) && !(num2 > 0) && num3 > 0;
        boolean result = res1 || res2 || res3;
        System.out.println(result);
    }
}
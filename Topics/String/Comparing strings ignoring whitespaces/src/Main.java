import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String compare1 = str1.replace(" ", "");
        String compare2 = str2.replace(" ", "");
        System.out.println(compare1.equals(compare2));
    }
}
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sample = scanner.nextLine();
        char[] sampleParts = sample.toCharArray();

        int l = sampleParts.length;

        boolean alphabet = true;

        for (int i = 0; i < l - 1; i++) {
            if (sampleParts[i + 1] - sampleParts[i] != 1) {
                alphabet = false;
            }
        }

        for (int i = 0; i < l; i++) {
            if (sampleParts[i] < 'a' || sampleParts[i] > 'z') {
                alphabet = false;
            }
        }

        System.out.println(alphabet);
    }
}
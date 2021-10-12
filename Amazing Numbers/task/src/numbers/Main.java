package numbers;

import java.util.Scanner;

public class Main {
    private static long number;
    private static int parameter;
    private static boolean isParameterEntered;
    private static boolean isEven;
    private static boolean isBuzz;
    private static boolean isDuck;
    private static boolean isPalindromic;
    private static boolean isGapful;

    public static void main(String[] args) {

        System.out.println("Welcome to Amazing Numbers!");
        printInstructions();
        getNumbers();

        while (number > 0) {
            if (isParameterEntered) {
                for (long i = number; i < number + parameter; i++) {
                    checkProperties(i);
                    printPropertiesMore(i);
                }
                System.out.println("\n");
            } else {
                checkProperties(number);
                printPropertiesOne();
            }
            getNumbers();
        }
        System.out.println("\nGoodbye!");
    }

    private static void printInstructions() {
        System.out.println("\nSupported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");
    }

    private static void getNumbers() {
        System.out.print("Enter a request: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.length() == 0) {
            printInstructions();
            getNumbers();
        } else if (input.contains(" ")) {
            String[] inputParts = input.split(" ");
            try {
                number = Long.parseLong(inputParts[0]);
            } catch (Exception e) {
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                getNumbers();
            }
            try {
                parameter = Integer.parseInt(inputParts[1]);
            } catch (Exception e) {
                System.out.println("\nThe second parameter should be a natural number.\n");
                getNumbers();
            }

            isParameterEntered = true;

            if (number < 0 && parameter < 0) {
                System.out.println("\nThe first parameter should be a natural number or zero.");
                System.out.println("\nThe second parameter should be a natural number.\n");
                getNumbers();
            } else if (number < 0) {
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                getNumbers();
            } else if (parameter < 0) {
                System.out.println("\nThe second parameter should be a natural number.\n");
                getNumbers();
            }

        } else {
            try {
                number = Long.parseLong(input);
                isParameterEntered = false;
            } catch (Exception e) {
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                getNumbers();
            }
            if (number < 0) {
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                getNumbers();
            }
        }
    }

    private static boolean isEven(long number) {
        return number % 2 == 0;
    }

    private static boolean isBuzz(long number) {
        long rest7 = number % 7;
        long rest10 = number % 10;
        return rest7 == 0 || rest10 == 7;
    }

    private static boolean isDuck(long number) {
        String numberStr = String.valueOf(number);
        boolean flag = false;
        for (int i = 0; i < numberStr.length(); i++) {
            if (numberStr.charAt(i) == '0') {
                flag = true;
            }
        }
        return flag;
    }

    private static boolean isPalindromic(long number) {
        String numberStr = String.valueOf(number);
        int length = numberStr.length();
        char[] numberTab = new char[length];

        for (int i = 0; i < length; i++) {
            numberTab[i] = numberStr.charAt(length - i - 1);
        }

        String invNumberStr = String.valueOf(numberTab);
        return invNumberStr.equals(numberStr);
    }

    private static boolean isGapful(long number) {
        String numberStr = String.valueOf(number);
        int len = numberStr.length();

        if (len < 3) {
            return false;
        }

        int firstDig = Character.getNumericValue(numberStr.charAt(0));
        int lastDig = Character.getNumericValue(numberStr.charAt(len - 1));
        int divider = (firstDig * 10) + lastDig;

        if (number % divider == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void checkProperties(long num) {
        isEven = isEven(num);
        isBuzz = isBuzz(num);
        isDuck = isDuck(num);
        isPalindromic = isPalindromic(num);
        isGapful = isGapful(num);
    }

    private static void printPropertiesOne() {
        System.out.println("\nProperties of " + number);
        System.out.println("\t\teven: " + isEven);
        System.out.println("\t\t odd: " + !isEven);
        System.out.println("\t\tbuzz: " + isBuzz);
        System.out.println("\t\tduck: " + isDuck);
        System.out.println(" palindromic: " + isPalindromic);
        System.out.println("\t  gapful: " + isGapful);
        System.out.println("");
    }

    private static void printPropertiesMore(long i) {
        System.out.print("\n" + i + " is");
        if (isEven) {
            System.out.print(" even");
        } else {
            System.out.print(" odd");
        }
        if (isBuzz) System.out.print(", buzz");
        if (isDuck) System.out.print(", duck");
        if (isPalindromic) System.out.print(", palindromic");
        if (isGapful) System.out.print(", gapful");
    }
}

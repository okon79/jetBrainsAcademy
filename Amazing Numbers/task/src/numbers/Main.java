package numbers;

import java.util.*;
import java.util.function.LongPredicate;

public class Main {
    public static int status;
    private static long number;
    private static int secondNumber;
    private static final String avParams = "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]";
    private static String[] parameters;
    private static HashMap<String, Boolean> results;
    private static boolean isSecondNumberEntered;
    private static int noOfParams;

    public static void main(String[] args) {

        status = 1;

        System.out.println("Welcome to Amazing Numbers!");
        printInstructions();

        while (status > 0) {

            status = getNumbers();

            if (status == 0) {
                break;
            }

            if (status == 1) {
                printInstructions();
            }

            if (noOfParams == 0 && !isSecondNumberEntered && status > 2) {
                printPropertiesOne();

            } else if (noOfParams == 0 && isSecondNumberEntered && status > 2) {
                for (long i = number; i < number + secondNumber; i++) {
                    printPropertiesMore(i);
                }
                System.out.println("\n");

            } else if (noOfParams > 0 && isSecondNumberEntered && status > 2) {
                int success = 0;
                while (success < secondNumber) {
                    if (processParam(parameters)) {
                        success++;
                    }
                    number++;
                }
                System.out.println("\n");
            }
        }

        System.out.println("\nGoodbye!");

    }

    private static void printInstructions() {
        System.out.println("\nSupported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and a property to search for;\n" +
                "- two natural numbers and two properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");
    }

    private static int getNumbers() {

        noOfParams = 0;
        isSecondNumberEntered = false;

        System.out.print("Enter a request: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.length() == 0) {
            return 1;
        }

        String[] inputParts = input.split(" ");
        StringBuilder errParList = new StringBuilder();

        if (inputParts.length >= 1) {
            try {
                number = Long.parseLong(inputParts[0]);
            } catch (Exception e) {
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                return 2;
            }
            if (number < 0) {
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                return 2;
            } else if (number == 0) {
                return 0;
            }
        }

        if (inputParts.length >= 2) {
            try {
                secondNumber = Integer.parseInt(inputParts[1]);
            } catch (Exception e) {
                System.out.println("\nThe second parameter should be a natural number.\n");
                return 2;
            }
            if (secondNumber <= 0) {
                System.out.println("\nThe second parameter should be a natural number.\n");
                return 2;
            }
            isSecondNumberEntered = true;
        }

        int noOfErrors = 0;

        if (inputParts.length >= 3) {
            parameters = new String[inputParts.length - 2];
            for (int i = 2; i < inputParts.length; i++) {
                if (!avParams.contains(inputParts[i].toUpperCase())) {
                    errParList.append(inputParts[i].toUpperCase() + ", ");
                    noOfErrors++;
                }
                parameters[i - 2] = inputParts[i].toUpperCase();
                noOfParams++;
            }
        }

        if (noOfErrors == 1) {
            System.out.println("The property [" + errParList + "] is wrong.");
            System.out.println("Available properties: " + avParams + "\n");
            return 2;
        } else if (noOfErrors > 1) {
            System.out.println("The properties [" + errParList + "] are wrong.");
            System.out.println("Available properties: " + avParams + "\n");
            return 2;
        }

        if (parameters != null) {
            String stringOfParameters = String.join(" ", parameters);
            if (stringOfParameters.contains("ODD") && stringOfParameters.contains("EVEN")) {
                System.out.println("\nThe request contains mutually exclusive properties: [EVEN, ODD]\n" +
                        "There are no numbers with these properties.\n");
                return 2;
            } else if (stringOfParameters.contains("SQUARE") && stringOfParameters.contains("SUNNY")) {
                System.out.println("\nThe request contains mutually exclusive properties: [SQUARE, SUNNY]\n" +
                        "There are no numbers with these properties.\n");
                return 2;
            } else if (stringOfParameters.contains("SPY") && stringOfParameters.contains("DUCK")) {
                System.out.println("\nThe request contains mutually exclusive properties: [SPY, DUCK]\n" +
                        "There are no numbers with these properties.\n");
                return 2;
            }
        }
        return 3;
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

        return number % divider == 0;
    }

    private static boolean isSpy(long number) {
        String numberStr = String.valueOf(number);
        int length = numberStr.length();
        int sum = 0;
        int product = 1;

        for (int i = 0; i < length; i++) {
            sum += Character.getNumericValue(numberStr.charAt(i));
            product *= Character.getNumericValue(numberStr.charAt(i));
        }

        return sum == product;
    }

    private  static boolean isSquare(long number) {
        double sqr = Math.sqrt((double) number);
        return sqr == (int) sqr;
    }

    private static boolean isSunny(long number) {
        return isSquare(++number);
    }

    private static boolean isJumping(long number) {
        String numberStr = String.valueOf(number);
        for (int i = 0; i < numberStr.length() - 1; i++) {
            if (Math.abs((long) numberStr.charAt(i) - (long) numberStr.charAt(i + 1)) != 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean processParam(String[] params) {

        results = new HashMap<>();
        results.clear();

        for (String parameter : params) {
            switch (parameter) {
                case "EVEN":
                    if (isEven(number)) {
                        results.put("EVEN", true);
                    }
                    break;
                case "ODD":
                    if (!isEven(number)) {
                        results.put("ODD", true);
                    }
                    break;
                case "BUZZ":
                    if (isBuzz(number)) {
                        results.put("BUZZ", true);
                    }
                    break;
                case "DUCK":
                    if (isDuck(number)) {
                        results.put("DUCK", true);
                    }
                    break;
                case "PALINDROMIC":
                    if (isPalindromic(number)) {
                        results.put("PALINDROMIC", true);
                    }
                    break;
                case "GAPFUL":
                    if (isGapful(number)) {
                        results.put("GAPFUL", true);
                    }
                    break;
                case "SPY":
                    if (isSpy(number)) {
                        results.put("SPY", true);
                    }
                    break;
                case "SQUARE":
                    if (isSquare(number)) {
                        results.put("SQUARE", true);
                    }
                    break;
                case "SUNNY":
                    if (isSunny(number)) {
                        results.put("SUNNY", true);
                    }
                    break;
                case "JUMPING":
                    if (isJumping(number)) {
                        results.put("JUMPING", true);
                    }
                    break;
                default:
                    System.out.println("Wrong Case");
                    return false;
            }
        }

        int numOfParams = params.length;
        int numOfResults = results.size();
        if (numOfResults == numOfParams) {
            printPropertiesMore(number);
        } else {
            return false;
        }
        return true;
    }

    private static void printPropertiesOne() {
        System.out.println("\nProperties of " + number);
        System.out.println("\t\teven: " + isEven(number));
        System.out.println("\t\t odd: " + !isEven(number));
        System.out.println("\t\tbuzz: " + isBuzz(number));
        System.out.println("\t\tduck: " + isDuck(number));
        System.out.println(" palindromic: " + isPalindromic(number));
        System.out.println("\t  gapful: " + isGapful(number));
        System.out.println("\t\t spy: " + isSpy(number));
        System.out.println("\t  square: " + isSquare(number));
        System.out.println("\t   sunny: " + isSunny(number));
        System.out.println("\t jumping: " + isJumping(number));
        System.out.println("");
    }

    private static void printPropertiesMore(long num) {
        System.out.print("\n" + num + " is");
        if (isEven(num)) {
            System.out.print(" even");
        } else {
            System.out.print(" odd");
        }
        if (isBuzz(num)) System.out.print(", buzz");
        if (isDuck(num)) System.out.print(", duck");
        if (isPalindromic(num)) System.out.print(", palindromic");
        if (isGapful(num)) System.out.print(", gapful");
        if (isSpy(num)) System.out.print(", spy");
        if (isSquare(num)) System.out.print(", square");
        if (isSunny(num)) System.out.print(", sunny");
        if (isJumping(num)) System.out.print(", jumping");
    }
}

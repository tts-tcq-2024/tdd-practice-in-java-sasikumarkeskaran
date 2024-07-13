package TddPracticeInJava;

public class StringCalculator {

    public int add(String input) {
        if (isEmpty(input)) {
            return 0;
        }
        String[] numbers = splitNumbers(input);
        return calculateSum(numbers);
    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private String[] splitNumbers(String input) {
        if (hasCustomDelimiter(input)) {
            return splitWithCustomDelimiter(input);
        }
        return splitWithDefaultDelimiter(input);
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private String[] splitWithCustomDelimiter(String input) {
        int delimiterIndex = input.indexOf('\n');
        String delimiter = input.substring(2, delimiterIndex);
        String numbersPart = input.substring(delimiterIndex + 1);
        return numbersPart.split(delimiter);
    }

    private String[] splitWithDefaultDelimiter(String input) {
        String delimiter = ",|\n";
        return input.split(delimiter);
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += toValidNumber(number);
        }
        return sum;
    }

    private int toValidNumber(String number) {
        int num = Integer.parseInt(number);
        if (num > 1000) {
            return 0;
        }
        return num;
    }
}

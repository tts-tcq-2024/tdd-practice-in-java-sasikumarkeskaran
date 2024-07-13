package TddPracticeInJava;

public class StringCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        
       
        String delimiter = ",|\n";
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf('\n');
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }
        
        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num <= 1000) {
                sum += num;
            }
        }
        return sum;
    }
}

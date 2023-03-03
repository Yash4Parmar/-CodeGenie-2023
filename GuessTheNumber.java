public class GuessTheNumber {
    public static void main(String[] args) {
        int finalNumber = 2500;
        String[] operations = { "X + 10", "X - 5", "X * 5", "X ^ 2" };

        int actualNumber = getActualNumber(finalNumber, operations, operations.length);
        System.out.println("The actual number will be " + actualNumber + " after performing given operations.");
    }

    public static int getActualNumber(int finalNumber, String[] operations, int totalOperations) {
        int result = finalNumber;
        for (int i = operations.length - 1; i >= 0; i--) {
            char op = operations[i].charAt(2);
            int number = Integer.parseInt(operations[i].substring(4));

            if ((op == '^' && number == 0) || (op == '*' && number == 0) || op == '%')
                return -2;
            if (op == '/' && number == 0) {
                return -1;
            }

            if (op == '+') {
                result -= number;
            } else if (op == '-') {
                result += number;
            } else if (op == '/') {
                result *= number;
            } else if (op == '*') {
                result /= number;
            } else {
                result = (int) Math.pow(result, 1f / number);
            }
        }
        return result;
    }
}
//Task 3 - Create a scientific calculator in Java

import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double num1, num2, result;
        char operator;

        System.out.print("Enter first number: ");
        num1 = input.nextDouble();

        System.out.print("Enter operator (+, -, *, /, %, sin:-s, cos:-c, tan:-t, log:-l, sqrt:-q): ");
        operator = input.next().charAt(0);

        if (isUnaryOperator(operator)) {
            result = calculateUnary(num1, operator);
        } else {
            System.out.print("Enter second number: ");
            num2 = input.nextDouble();
            result = calculateBinary(num1, num2, operator);
        }

        System.out.println("Result: " + result);
    }

    private static boolean isUnaryOperator(char op) {
        return op == 's' || op == 'c' || op == 't' || op == 'l' || op == 'q';
    }

    private static double calculateBinary(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return b == 0 ? Double.NaN : a / b;
            case '%': return a % b;
            default: return Double.NaN;
        }
    }

    private static double calculateUnary(double num, char op) {
        switch (op) {
            case 's': return Math.sin(Math.toRadians(num));
            case 'c': return Math.cos(Math.toRadians(num));
            case 't': return Math.tan(Math.toRadians(num));
            case 'l': return Math.log10(num);
            case 'q': return Math.sqrt(num);
            default: return Double.NaN;
        }
    }
}

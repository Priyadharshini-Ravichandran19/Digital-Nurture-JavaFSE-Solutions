import java.util.Scanner;

public class MathCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.println("Choose operation: +  -  *  /");
        char op = sc.next().charAt(0);

        double result;

        if (op == '+') {
            result = num1 + num2;
        }
        else if (op == '-') {
            result = num1 - num2;
        }
        else if (op == '*') {
            result = num1 * num2;
        }
        else if (op == '/') {
            result = num1 / num2;
        }
        else {
            System.out.println("Invalid operator");
            return;
        }

        System.out.println("Result: " + result);
    }
}
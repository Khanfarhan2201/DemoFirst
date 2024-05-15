import java.util.Scanner;

public class DisariumNumber {

    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static boolean isDisarium(int number) {
        int originalNumber = number;
        int numberOfDigits = countDigits(number);
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numberOfDigits);
            numberOfDigits--;
            number /= 10;
        }
        return originalNumber == sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scanner.nextInt();
        if (isDisarium(num)) {
            System.out.println(num + " is a Disarium number.");
        } else {
            System.out.println(num + " is not a Disarium number.");
        }
        scanner.close();
    }
}

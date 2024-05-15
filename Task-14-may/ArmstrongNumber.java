import java.util.Scanner;

public class ArmstrongNumber {

  public static int countDigits(int number) {
      int count = 0;
      while (number != 0) {
          count++;
          number /= 10;
      }
      return count;
  }

  public static boolean isArmstrong(int number) {
      int originalNumber = number;
      int numberOfDigits = countDigits(number);
      int sum = 0;
      
      while (number != 0) {
          int digit = number % 10;
          sum += Math.pow(digit, numberOfDigits);
          number /= 10;
      }
      
      return originalNumber == sum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number");
    int num = sc.nextInt();      if (isArmstrong(num)) {
          System.out.println(num + " is an Armstrong number.");
      } else {
          System.out.println(num + " is not an Armstrong number.");
      }
  }
}

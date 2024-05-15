import java.util.Scanner;


public class primeNumber {
  public boolean isPrime(int num, int i) {
      if (num <= 2) {
          return (num == 2) ? true : false;
      }
      if (num % i == 0) {
          return false;
      }
      if (i * i > num) {
          return true;
      }

      return isPrime(num, i + 1);
  }

  public static void main(String[] args) {
      primeNumber primeChecker = new primeNumber();
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a number");
      int num = sc.nextInt();
      boolean isPrime = primeChecker.isPrime(num, 2);
      if (isPrime) {
          System.out.println(num + " is a prime number.");
      } else {
          System.out.println(num + " is not a prime number.");
      }
  }
}

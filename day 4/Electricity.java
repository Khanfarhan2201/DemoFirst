import java.util.Scanner;

public class Electricity {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the units consumed: ");
        int units = scanner.nextInt();

        double bill = (units >= 0 && units <= 100) ? units * 2 :
                     (units >= 101 && units <= 150) ? (100 * 2) + ((units - 100) * 3) :
                     (units >= 151 && units <= 200) ? (100 * 2) + (50 * 3) + ((units - 150) * 4) :
                     (units >= 201 && units <= 250) ? (100 * 2) + (50 * 3) + (50 * 4) + ((units - 200) * 5) :
                     (units >= 251 && units <= 300) ? (100 * 2) + (50 * 3) + (50 * 4) + (50 * 5) + ((units - 250) * 6) :
                     (units >= 301 && units <= 500) ? (100 * 2) + (50 * 3) + (50 * 4) + (50 * 5) + (50 * 6) + ((units - 300) * 7) :
                     (units > 500) ? (100 * 2) + (50 * 3) + (50 * 4) + (50 * 5) + (50 * 6) + (200 * 7) + ((units - 500) * 8) :
                     0; 
        System.out.println("Electricity bill: Rs. " + bill);
    }

}

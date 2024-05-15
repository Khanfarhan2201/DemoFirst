import java.util.Scanner;

public class Factorial {
  public int fact(int num){
    if (num==1){
      return 1;
    }

    else{
      return fact(num-1) * num;
    }
  }


  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println();
    System.out.println("enter a number");
    int num = sc.nextInt();
    Factorial obj = new Factorial();
    int res = obj.fact(num);
    System.out.println("Factorial of " + num + " is: " + res); 
      
  }
}

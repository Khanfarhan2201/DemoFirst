import java.util.Scanner;

public class PeakElement {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        System.out.print("Enter the elements of the array separated by spaces: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int peakIndex = findPeak(arr);

        if (peakIndex != -1) {
            System.out.println("Peak element smaller than its neighbors: " + arr[peakIndex]);
        } else {
            System.out.println("No peak element smaller than its neighbors found.");
        }
    }

    public static int findPeak(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                return i;
            }
        }
        return -1; 
    }
}

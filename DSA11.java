
import java.util.Scanner;

public class DSA11 {

    // Merge Sort
    static void mergeSort(int a[], int n) {
        if (n < 2)
            return;

        int mid = n / 2;

        int left[] = new int[mid];
        int right[] = new int[n - mid];

        for (int i = 0; i < mid; i++)
            left[i] = a[i];

        for (int i = mid; i < n; i++)
            right[i - mid] = a[i];

        mergeSort(left, left.length);
        mergeSort(right, right.length);

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                a[k++] = left[i++];
            else
                a[k++] = right[j++];
        }

        while (i < left.length)
            a[k++] = left[i++];

        while (j < right.length)
            a[k++] = right[j++];
    }

    // Quick Sort
    static void quickSort(int a[], int low, int high) {
        if (low < high) {
            int pivot = a[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (a[j] < pivot) {
                    i++;

                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }

            int temp = a[i + 1];
            a[i + 1] = a[high];
            a[high] = temp;

            int p = i + 1;

            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
    }

    // Display Array
    static void display(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        int a[] = new int[n];

        System.out.println("Enter product prices:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("1. Merge Sort");
        System.out.println("2. Quick Sort");

        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();

        if (ch == 1) {
            mergeSort(a, n);
            System.out.println("Using Merge Sort:");
        } 
        else if (ch == 2) {
            quickSort(a, 0, n - 1);
            System.out.println("Using Quick Sort:");
        } 
        else {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }

        System.out.print("Sorted Product Prices: ");
        display(a);

        sc.close();
    }
}

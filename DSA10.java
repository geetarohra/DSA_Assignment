
import java.util.Scanner;

public class DSA10 {

    // Selection Sort
    static void selectionSort(int marks[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (marks[j] < marks[min]) {
                    min = j;
                }
            }

            int temp = marks[i];
            marks[i] = marks[min];
            marks[min] = temp;
        }
    }

    // Insertion Sort
    static void insertionSort(int marks[], int n) {
        for (int i = 1; i < n; i++) {
            int key = marks[i];
            int j = i - 1;

            while (j >= 0 && marks[j] > key) {
                marks[j + 1] = marks[j];
                j--;
            }

            marks[j + 1] = key;
        }
    }

    // Display Marks
    static void display(int marks[], int n) {
        System.out.print("Sorted Marks: ");

        for (int i = 0; i < n; i++) {
            System.out.print(marks[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int marks[] = new int[n];

        System.out.println("Enter student marks:");

        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        System.out.println("\n--- SORTING MENU ---");
        System.out.println("1. Selection Sort");
        System.out.println("2. Insertion Sort");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                selectionSort(marks, n);
                System.out.println("Using Selection Sort:");
                display(marks, n);
                break;

            case 2:
                insertionSort(marks, n);
                System.out.println("Using Insertion Sort:");
                display(marks, n);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}

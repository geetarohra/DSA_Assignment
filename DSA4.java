import java.util.Scanner;

public class DSA4 {

    int size = 5;
    int queue[] = new int[size];

    int front = -1;
    int rear = -1;

    // Add print job
    void enqueue(int job) {

        if ((rear + 1) % size == front) {
            System.out.println("Print Queue is Full");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        queue[rear] = job;

        System.out.println("Print Job " + job + " added");
    }

    // Complete print job
    void dequeue() {

        if (front == -1) {
            System.out.println("Print Queue is Empty");
            return;
        }

        System.out.println("Print Job " + queue[front] + " completed");

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    // Display print queue
    void display() {

        if (front == -1) {
            System.out.println("Print Queue is Empty");
            return;
        }

        System.out.print("Print Queue: ");

        int i = front;

        while (true) {

            System.out.print(queue[i] + " ");

            if (i == rear) {
                break;
            }

            i = (i + 1) % size;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DSA4 q = new DSA4();

        while (true) {

            System.out.println("\n1. Add Print Job");
            System.out.println("2. Complete Print Job");
            System.out.println("3. Display Print Queue");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Print Job Number: ");
                    int job = sc.nextInt();
                    q.enqueue(job);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.display();
                    break;

                case 4:
                    System.out.println("Program Ended");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
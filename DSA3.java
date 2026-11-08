import java.util.Scanner;

public class DSA3 {

    int size = 5;
    int queue[] = new int[size];

    int front = -1;
    int rear = -1;

    // Enqueue - Add customer
    void enqueue(int customer) {

        if (rear == size - 1) {
            System.out.println("Queue is Full");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear++;
        queue[rear] = customer;

        System.out.println("Customer " + customer + " joined the queue");
    }

    // Dequeue - Serve customer
    void dequeue() {

        if (front == -1 || front > rear) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("Customer " + queue[front] + " is served");

        front++;

        if (front > rear) {
            front = -1;
            rear = -1;
        }
    }

    // Peek - Show first customer
    void peek() {

        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("Next Customer: " + queue[front]);
    }

    // Display queue
    void display() {

        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Queue: ");

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DSA3 q = new DSA3();

        while (true) {

            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Customer Number: ");
                    int customer = sc.nextInt();
                    q.enqueue(customer);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.peek();
                    break;

                case 4:
                    q.display();
                    break;

                case 5:
                    System.out.println("Program Ended");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
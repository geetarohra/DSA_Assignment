
import java.util.Scanner;

class DSA6 {

    class Node {
        String patientName;
        Node next;

        Node(String name) {
            patientName = name;
            next = null;
        }
    }

    Node top = null;

    void push(String name) {
        Node newNode = new Node(name);
        newNode.next = top;
        top = newNode;
        System.out.println(name + " added successfully.");
    }

    void pop() {
        if (top == null) {
            System.out.println("No patient records available.");
        } else {
            System.out.println("Removed patient: " + top.patientName);
            top = top.next;
        }
    }

    void display() {
        if (top == null) {
            System.out.println("No patient records available.");
            return;
        }

        Node temp = top;
        System.out.println("Patient Records:");

        while (temp != null) {
            System.out.println(temp.patientName);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSA6 s = new DSA6();

        int choice;
        String name;

        do {
            System.out.println("\n1. Add Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. Display Patients");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    name = sc.nextLine();
                    s.push(name);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    s.display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}

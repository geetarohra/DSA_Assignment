
import java.util.Scanner;

class DSA7 {

    class Node {
        String name;
        Node next;

        Node(String name) {
            this.name = name;
            next = null;
        }
    }

    Node head = null;

    // Insert player
    void insert(String name) {
        Node newNode = new Node(name);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }

        System.out.println(name + " added.");
    }

    // Delete player
    void delete(String name) {
        if (head == null) {
            System.out.println("No players available.");
            return;
        }

        Node temp = head;
        Node prev = null;

        do {
            if (temp.name.equals(name)) {
                if (temp == head && temp.next == head) {
                    head = null;
                } else if (temp == head) {
                    Node last = head;

                    while (last.next != head) {
                        last = last.next;
                    }

                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }

                System.out.println(name + " deleted.");
                return;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        System.out.println("Player not found.");
    }

    // Display players and turns
    void display() {
        if (head == null) {
            System.out.println("No players available.");
            return;
        }

        Node temp = head;

        System.out.println("Players and their turns:");

        do {
            System.out.println(temp.name);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSA7 list = new DSA7();

        int choice;
        String name;

        do {
            System.out.println("\n1. Insert Player");
            System.out.println("2. Delete Player");
            System.out.println("3. Display Players");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter player name: ");
                    name = sc.nextLine();
                    list.insert(name);
                    break;

                case 2:
                    System.out.print("Enter player name to delete: ");
                    name = sc.nextLine();
                    list.delete(name);
                    break;

                case 3:
                    list.display();
                    break;

                case 4:
                    System.out.println("Game ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}


import java.util.Scanner;

class DSA8 {

    class Node {
        int roll;
        Node left, right;

        Node(int roll) {
            this.roll = roll;
            left = right = null;
        }
    }

    Node root = null;

    // Insert roll number
    Node insert(Node root, int roll) {
        if (root == null) {
            return new Node(roll);
        }

        if (roll < root.roll) {
            root.left = insert(root.left, roll);
        } else if (roll > root.roll) {
            root.right = insert(root.right, roll);
        } else {
            System.out.println("Roll number already exists.");
        }

        return root;
    }

    // Search roll number
    void search(Node root, int roll) {
        if (root == null) {
            System.out.println("Student not found.");
        } else if (root.roll == roll) {
            System.out.println("Student found.");
        } else if (roll < root.roll) {
            search(root.left, roll);
        } else {
            search(root.right, roll);
        }
    }

    // Find smallest value
    Node minimum(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Delete roll number
    Node delete(Node root, int roll) {
        if (root == null) {
            return null;
        }

        if (roll < root.roll) {
            root.left = delete(root.left, roll);
        } else if (roll > root.roll) {
            root.right = delete(root.right, roll);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node temp = minimum(root.right);
            root.roll = temp.roll;
            root.right = delete(root.right, temp.roll);
        }

        return root;
    }

    // Inorder traversal
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.roll + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSA8 tree = new DSA8();

        int choice, roll;

        do {
            System.out.println("\n1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display (Inorder)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student roll number: ");
                    roll = sc.nextInt();
                    tree.root = tree.insert(tree.root, roll);
                    break;

                case 2:
                    System.out.print("Enter roll number to search: ");
                    roll = sc.nextInt();
                    tree.search(tree.root, roll);
                    break;

                case 3:
                    System.out.print("Enter roll number to delete: ");
                    roll = sc.nextInt();

                    if (tree.root == null) {
                        System.out.println("Tree is empty.");
                    } else {
                        tree.root = tree.delete(tree.root, roll);
                        System.out.println("Deletion operation completed.");
                    }
                    break;

                case 4:
                    System.out.print("Roll numbers in sorted order: ");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}

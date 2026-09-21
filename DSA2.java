
import java.util.Scanner;

class InfixToPostfix {

    char stack[] = new char[100];
    int top = -1;

    void push(char c) {
        stack[++top] = c;
    }

    char pop() {
        return stack[top--];
    }

    int priority(char c) {
        if (c == '+' || c == '-')
            return 1;
        if (c == '*' || c == '/')
            return 2;
        if (c == '^')
            return 3;
        return 0;
    }

    String convert(String infix) {
        String postfix = "";

        for (char c : infix.toCharArray()) {

            if (Character.isLetterOrDigit(c)) {
                postfix += c;
            }

            else if (c == '(') {
                push(c);
            }

            else if (c == ')') {
                while (stack[top] != '(') {
                    postfix += pop();
                }
                pop();
            }

            else {
                while (top != -1 &&
                       priority(stack[top]) >= priority(c)) {
                    postfix += pop();
                }

                push(c);
            }
        }

        while (top != -1) {
            postfix += pop();
        }

        return postfix;
    }
}

public class DSA2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String infix = sc.nextLine();

        InfixToPostfix obj = new InfixToPostfix();

        System.out.println("Postfix expression: "
                + obj.convert(infix));

        sc.close();
    }
}
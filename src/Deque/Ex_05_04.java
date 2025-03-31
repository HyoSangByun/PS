package Deque;

import java.util.Scanner;
import java.util.Stack;

public class Ex_05_04 { //후위식 연산 (postfix)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        char[] charArray = next.toCharArray();

        Stack<Integer> stack = new Stack<>();

        for (char c : charArray) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;

                switch (c) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                }
                stack.push(result);
            }
        }

        int answer = stack.pop();
        System.out.println(answer);
    }
}

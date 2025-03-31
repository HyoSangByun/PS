package Deque;

import java.util.Scanner;
import java.util.Stack;

public class Ex_05_01 { //올바른 괄호
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArray = sc.next().toCharArray();

        Stack<Character> stack = new Stack<>();
        String answer = "YES";

        for (char c : charArray) {
            if ( c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    answer = "NO";
                    break;
                } else stack.pop();
            }
        }

        if (stack.size() > 0) answer = "NO";
        System.out.println(answer);
    }
}

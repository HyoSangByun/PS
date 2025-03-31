package Implement;

import java.util.Scanner;
import java.util.Stack;

public class Ex_1918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (Character.isLetter(ch)) { // 피연산자
                sb.append(ch);
            } else if (ch == '(') { // 왼쪽 괄호는 무조건 스택에 푸시
                stack.push(ch);
            } else if (ch == ')') { // 오른쪽 괄호는 '('가 나올 때까지 pop
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); // '(' 제거
            } else { // 연산자 처리
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // 스택에 남아 있는 연산자들을 모두 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    // 연산자의 우선순위를 반환하는 메서드
    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') return 1;
        if (operator == '*' || operator == '/') return 2;
        return 0; // '('의 우선순위는 0
    }
}

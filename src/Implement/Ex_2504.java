package Implement;

import java.util.Scanner;
import java.util.Stack;

public class Ex_2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int temp = 1;

        // 괄호열이 올바른지, 값을 동시에 계산
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // 여는 괄호일 때는 스택에 넣고 임시값(temp)을 곱해줍니다
            if (c == '(') {
                stack.push(c);
                temp *= 2;
            } else if (c == '[') {
                stack.push(c);
                temp *= 3;
            }
            // 닫는 괄호를 만났을 때
            else if (c == ')') {
                // 스택이 비어있거나 짝이 맞지 않는 경우는 올바른 괄호열이 아님
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                // 이전 문자가 여는 괄호였으면 현재 temp 값을 더해줌
                if (input.charAt(i - 1) == '(') {
                    result += temp;
                }
                stack.pop();
                temp /= 2;  // 닫았으니 나누어줌
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                if (input.charAt(i - 1) == '[') {
                    result += temp;
                }
                stack.pop();
                temp /= 3;  // 닫았으니 나누어줌
            }
        }

        // 스택이 비어있지 않으면 괄호가 짝을 맞추지 않은 경우
        if (!stack.isEmpty()) {
            result = 0;
        }

        System.out.println(result);
    }
}

/*
    분배법칙을 이용한 거임

    예시로 (()[[]])([])의 경우
    2 * ( 2 + 3 * 3) + 2 * 3 이다.
    분배법칙을 적용하면
    2 * 2 + 2 * 3 * 3 + 2 * 3 이다.

    즉, 열림의 경우는 tmp 에 2 나 3을 곱하고
    닫힘의 경우는 곱한 것을 ans에 더해주고 tmp를 2 나 3으로 나눠줘야 한다.
 */
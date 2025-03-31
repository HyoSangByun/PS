package Implement;

import java.util.Scanner;
import java.util.Stack;

public class Ex_10828 {
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String nextLine = sc.nextLine();
            stack(nextLine);
        }

        System.out.println(sb.toString());
    }

    private static void stack(String in) {
        if (in.startsWith("push")) {
            String[] parts = in.split(" ");
            stack.push(Integer.valueOf(parts[1]));
        } else if (in.equals("pop")) {
            if (stack.isEmpty()) sb.append(-1).append('\n');
            else sb.append(stack.pop()).append('\n');
        } else if (in.equals("size")) {
            sb.append(stack.size()).append('\n');
        } else if (in.equals("empty")) {
            if (stack.isEmpty()) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        } else if (in.equals("top")) {
            if (stack.isEmpty()) sb.append(-1).append('\n');
            else sb.append(stack.peek()).append('\n');
        }
    }
}

/*
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
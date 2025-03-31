package Deque;

import java.util.Scanner;
import java.util.Stack;

public class Ex_05_05_02 { //쇠막대기 !못품
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArray = sc.next().toCharArray();
        // ()(((()())(())()))(())
        /*
            ()(((()())(())()))(())
              ----------------
                ------------
                 ---- ---     ----
            연속되지 않은 괄호 사이에 연속된 괄호가 몇 개 있는지 세고
            연속된 괄호 갯수 + 1 해주면 됨
         */
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < charArray.length; i++) {
            int k = i +1;
            if (charArray[i] == '(' && charArray[k] != ')') {
                stack.push('(');
                while (!stack.isEmpty()) {
                    if (charArray[++i] == '(') stack.push('(');
                    else {
                        stack.pop();
                        if (!stack.isEmpty()) count++;
                        sum += (count + 1);
                        count = 0;
                    }
                }
            }
        }

        System.out.println(sum);

    }
}

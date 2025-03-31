package Deque;

import java.util.Scanner;
import java.util.Stack;

public class Ex_05_02 { //괄호문자제거
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArray = sc.next().toCharArray();

        //(A(BC)D)EF(G(H)(IJ)K)LM(N)
        //EFLM

        Stack<Character> stack = new Stack<>();
        String answer = "";

        for (int i = 0; i < charArray.length; i++) {
            if ( charArray[i] == '(' ) {
                stack.push(charArray[i]);
            } else if (charArray[i] == ')') {
                stack.pop();
            } else {
                if (stack.isEmpty()) answer += charArray[i];
            }
        }

        System.out.println(answer);
    }
}

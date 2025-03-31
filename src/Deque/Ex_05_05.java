package Deque;

import java.util.Scanner;
import java.util.Stack;

public class Ex_05_05 { //후위식 연산 (postfix)
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
            if (charArray[i] == '(') {
                if (charArray[i+1] == ')') { //레이저 발사
                    if ( !stack.isEmpty() ) count ++;
                } else { // 막대기
                    stack.push('(');
                }
            } else { // ) 입력 받았을 때
                if(charArray[i-1] != '(') {
                    stack.pop();
                    System.out.println(count);
                    sum += (count + 1);
                    if (stack.isEmpty()) count = 0;
                }
            }
        }

        System.out.println(sum);

    }
}

/*
여는 괄호는 스택에 push
닫는 괄호가 레이저인지 막대 끝인지 확인해야 함

레이저면 pop()하고, answer에 stack size(잘린 막대기 갯수) 기록
막대 끝이면 pop()하고, 짜투리 하나를 answer에 추가
 */
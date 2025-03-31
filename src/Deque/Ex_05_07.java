package Deque;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_05_07 { //교육과정 설계
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] array1 = sc.next().toCharArray();
        char[] array2 = sc.next().toCharArray();

        Queue<Character> list1 = new LinkedList<>();
//        Queue<Character> list2 = new LinkedList<>();

        for (char c : array1) {
            list1.offer(c);
        }

        for (char c : array2) {
            if( !list1.isEmpty() && c == list1.peek() ) list1.poll();
        }

        if (list1.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
    }
}

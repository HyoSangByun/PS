package Sorting_Searching;

import java.util.*;

public class Ex_06_04 { //Least Recently Used
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int nextInt = sc.nextInt();

            if (stack.size() < s && !stack.contains(nextInt)) stack.push(nextInt);
            else if (stack.contains(nextInt)) {
                stack.remove((Integer) nextInt);
                stack.push(nextInt);
            } else if (stack.size() == s && !stack.contains(nextInt)) {
                stack.remove(stack.getLast());
                stack.push(nextInt);
            }

        }

        for (Integer i : stack) {
            System.out.print(i + " ");
        }
    }
}

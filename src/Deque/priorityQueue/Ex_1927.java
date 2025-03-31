package Deque.priorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex_1927 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int nextInt = sc.nextInt();
            if (nextInt == 0) {
                if (pQ.isEmpty()) {
                    System.out.println(0);
                }else {
                    System.out.println(pQ.poll());
                }
            } else {
                pQ.offer(nextInt);
            }

        }
    }

}

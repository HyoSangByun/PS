package Deque.priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex_11279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int nextInt = sc.nextInt();
            if (nextInt == 0) {
                //가장 큰 값을 뺌
                if (pQ.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pQ.poll());
                }
            } else {
                pQ.add(nextInt);
            }
        }
    }

}

package greedy.baekjoon;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex_01 { //백준 11047
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int nextInt = sc.nextInt();
            pQ.offer(nextInt);
        }

        int count = 0;
        while (K != 0) {
            if (!pQ.isEmpty() && pQ.peek() > K) pQ.poll();
            else if (!pQ.isEmpty() && pQ.peek() <= K ) {
                count++;
                K -= pQ.peek();
            }
        }

        System.out.println(count);
    }
}

package greedy.baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex_04 { //백준 1715
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            pQ.offer(sc.nextInt());
        }

        int i1 = 0;
        int i2 = 0;
        int sum = 0;
        while (true) {
            if (!pQ.isEmpty()) i1 = pQ.poll();

            if (!pQ.isEmpty()) i2 = pQ.poll();
            else break;

            int i = i1 + i2;
            sum += i;
            pQ.offer(i);
        }

        System.out.println(sum);
    }
}

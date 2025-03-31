package Deque.priorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex_11286 {

    static class Num implements Comparable<Num> {
        private int x;

        public Num(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(Num o) {
            if (Math.abs(this.x)== Math.abs(o.x)) {
                return this.x - o.x;
            }
            return Math.abs(this.x) - Math.abs(o.x);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Num> pQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int nextInt = sc.nextInt();
            if (nextInt == 0) {
                if (pQ.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pQ.poll().x);
                }
            } else {
                pQ.offer(new Num(nextInt));
            }
        }
    }

}

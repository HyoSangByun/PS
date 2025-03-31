package greedy.baekjoon;

import java.util.*;

public class Ex_12 { //백준 1744
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
//        Integer[] arr = new Integer[N];
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int nextInt = sc.nextInt();
            if (nextInt < 0) count++;
            pQ.add(nextInt);
        }

        if (N==1) {
            System.out.println(pQ.poll());
            return;
        }

        int sum = 0;
        if (!pQ.isEmpty() && pQ.peek() < 0) {
            while (!pQ.isEmpty()) {
                Integer poll = pQ.poll(); //반드시 음수
                if (!pQ.isEmpty() && pQ.peek() <=0 ) {
                    sum+= pQ.poll() * poll;
                } else if (!pQ.isEmpty() && pQ.peek() >0) {
                    sum+=poll;
                    break;
                }

                if (!pQ.isEmpty() && pQ.peek() >= 0) break;
            }
        }

        // 내림차순으로 새롭게 PriorityQueue 생성
        PriorityQueue<Integer> reversedPQ = new PriorityQueue<>(Collections.reverseOrder());
        reversedPQ.addAll(pQ);

        while (!reversedPQ.isEmpty()) {
            Integer poll = reversedPQ.poll();
            if (!reversedPQ.isEmpty() && reversedPQ.peek() > 1) sum += poll * reversedPQ.poll();
            else sum += poll;
        }

        System.out.println(sum);
    }
}

/*
    음수면 0이하면 곱함
    0이면 더함
    양수면 곱합
 */
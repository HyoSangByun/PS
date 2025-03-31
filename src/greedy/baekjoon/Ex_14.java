package greedy.baekjoon;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Ex_14 { //백준 1700
    static class Number implements Comparable<Number>{
        private int count;
        private int number;

        public Number(int count, int number) {
            this.count = count;
            this.number = number;
        }

        @Override
        public int compareTo(Number o) {
            return this.count - o.count;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[K + 1];
        boolean[] ch = new boolean[K + 1];
        Queue<Integer> Q = new LinkedList<>();
        PriorityQueue<Number> pQ = new PriorityQueue<>(); //작은것부터 내보냄

        for (int i = 0; i < K; i++) {
            int nextInt = sc.nextInt();
            arr[nextInt] = Math.max(i, arr[nextInt]);
            Q.offer(nextInt);
        }

        int answer = 0;
        int j = 0;
        while (!Q.isEmpty()) {
            Integer poll = Q.poll();

            if (pQ.size() < N) {
                pQ.add(new Number(arr[poll], poll));
                ch[poll] = true;
            }
            else {
                if (!ch[poll]) { //꽉차있고 현재 안 꽃혀있는게 들어옴
                    Number existed = pQ.poll();
                    ch[existed.number] = false;

                    pQ.add(new Number(arr[poll], poll));
                    ch[poll] = true;
                    answer++;
                }
            }

            j++;
        }

        System.out.println(answer);
    }
}

/*
    꽉차있고 꽂혀있는게 들어옴 -> 아무것도 안함
    꽉차있고 안 꽂혀있는게 들어옴 -> 우선순위 낮은 걸 버림

    위 방식이 아닌
    현재 시점에서 가장 나중에 사용할 기기를 빼는게 맞음
 */
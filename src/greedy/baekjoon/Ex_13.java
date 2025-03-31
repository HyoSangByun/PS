package greedy.baekjoon;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex_13 { //백준 1339
    static class Alphabet implements Comparable<Alphabet>{
        private int weight;
        private char alpha;

        public Alphabet(int weight, char alpha) {
            this.weight = weight;
            this.alpha = alpha;
        }

        @Override
        public int compareTo(Alphabet o) {
            return o.weight - this.weight; // 내림차순 정렬
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] weights = new int[26];  // 알파벳 A~Z의 가중치를 저장할 배열

        int n = sc.nextInt();

        // 입력된 단어에 대해 자리수별 가중치 계산
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            int length = word.length();
            for (int j = 0; j < length; j++) {
                char c = word.charAt(j);
                weights[c - 'A'] += Math.pow(10, length - j - 1);  // 자리수에 따른 가중치 계산
            }
        }

        // 가중치가 큰 알파벳부터 우선 배정
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int weight : weights) {
            if (weight > 0) {
                pQ.add(weight);  // 가중치가 0보다 큰 알파벳만 추가
            }
        }

        // 숫자 배정
        int sum = 0;
        int num = 9;
        while (!pQ.isEmpty()) {
            sum += pQ.poll() * num--;  // 가중치가 큰 알파벳에 큰 숫자부터 할당
        }

        // 결과 출력
        System.out.println(sum);
    }

}

/*
    자릿수를 비교해서 큰 자리 숫자 앞쪽은 큰수로
    ABC라는 단어에서 A는 100, B는 10, C는 1의 가중치를 가져야 합니다.

 */
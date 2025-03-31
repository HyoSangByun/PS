package Deque;

import java.util.*;

public class Ex_05_06 { //공주 구하기 !못품
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();


        Queue<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.offer(i);
        }

        // 마지막 남은 왕자를 찾을 때까지 반복
        while (list.size() > 1) {
            // K-1번만큼 앞의 왕자들을 뒤로 보냄
            for (int i = 1; i < k; i++) {
                int prince = list.poll();
                list.offer(prince);
            }
            // K번째 왕자를 제외
            list.poll();
        }

        // 마지막으로 남은 왕자가 공주를 구하러 감
        System.out.println(list.poll());

    }
}

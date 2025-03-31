package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex_10_04 { //가장 높은 탑 쌓기 (LIS 응용)
    static class Bricks implements Comparable<Bricks> {
        private int s, h, w;

        public Bricks(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Bricks o) {
            return o.s-this.s;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Bricks> arr = new ArrayList<>();
        int[] dy = new int[N];

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            arr.add(new Bricks(a, b, c));
        }

        Collections.sort(arr);
        dy[0] = arr.get(0).h;
        int answer = dy[0];

        for (int i = 1; i < N; i++) {
            int max_h = 0;
            for (int j = i-1; j >= 0; j--) {
                if (arr.get(j).w > arr.get(i).w && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }
            dy[i] = max_h + arr.get(i).h;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }
}

/*
    dy에 i번쨰 벽돌이 가장 위에 있을 때 높이의 최댓값을 저장하는 방식으로 문제 해결
 */
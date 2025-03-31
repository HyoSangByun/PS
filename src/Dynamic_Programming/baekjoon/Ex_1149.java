package Dynamic_Programming.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_1149 {
    static List<List<Integer>> list = new ArrayList<>();
    static int N, answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                list.get(i).add(sc.nextInt()); // 각 집에 대해 3개의 색깔 비용 입력
            }
        }


        recur(0,-1,0);
        System.out.println(answer);
    }

    static void recur(int house, int beforeColor, int sum) { //L은 집 s는 색깔
        if (house == N ) {
            answer = Math.min(answer, sum);
        }
        else {
            for (int i = 0; i < 3; i++) {
                if (beforeColor != i) {
                    Integer color = list.get(house).get(i);
                    if (sum + color < answer) recur(house + 1, i, sum + color);
                }
            }
        }
    }
}

/*

 */

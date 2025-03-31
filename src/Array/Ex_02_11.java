package Array;

import java.util.*;

public class Ex_02_11 { //임시 반장 정하기 !못품
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                arr[i][j] = sc.nextInt();
            }
        }

        List<Integer> count = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                if (! map.containsKey(arr[j][i])) map.put(arr[j][i], j+1); //반과 학생번호를 넣음
                else {
                    count.add(map.get(arr[j][i]));
                    count.add(j+1);
                }
            }
        }
        System.out.println(count);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int answerCount = 0;
            for (Integer c : count) {
                if(i == c) answerCount++;
            }
            if (answerCount > answer) answer = i;
            System.out.println(i +" : " + answerCount);
        }
        System.out.println(answer);
    }
}


/*
삼중포문 이용
i번 학생이 j 학생에서 k학년동안 같은 반이 되어었는지 확인
그런데 같은 학생끼리 같은 반인 경우는 한번만 카운팅해야 하므로 break


 */
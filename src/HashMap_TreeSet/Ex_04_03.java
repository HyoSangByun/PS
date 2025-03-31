package HashMap_TreeSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Ex_04_03 { //매출액의 종류 !Time Limit Exceeded
    public static void main(String[] args) {
        /*
            7 4 n k
            20 12 20 10 23 17 10
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = k; i <= n; i++) {
            HashSet<Integer> set = new HashSet<>();

            for (int j = i-k; j < i; j++) {
                set.add(arr[j]);
            }
            answer.add(set.size());
        }

        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }
}

/*
sliding window 이용 (lt, rt)
lt는 윈도우의 맨 왼쪽
rt는 윈도우의 맨 오른쪽

lt는 카운팅을 하나빼주고 ++
rt는 카운팅 하나 더 해주고 ++

카운팅 뺏을때 값이 0이면 key도 삭제해야함!
 */
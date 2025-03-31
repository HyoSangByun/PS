package Swea;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ex_3752_2 {
    static Set<Integer> set = new HashSet<Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            set.clear();
            int N = sc.nextInt();
            int[] arr = new int[N];
            set.add(0);
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            for(int i=0; i<arr.length; i++) {
                scoreSelect(arr[i]);
            }

            System.out.println("#" + test_case + " " + set.size());
        }
        sc.close();
    }

    static void scoreSelect(int num) {
        Set<Integer> tmpSet = new HashSet<Integer>();
        tmpSet.addAll(set);
        Iterator<Integer> it = tmpSet.iterator();
        while(it.hasNext()) {
            set.add(it.next()+num);
        }
    }
}

/*
    DFS로 조합으로 할 경우 문제의 갯수가 최대 100개라면 100C1 부터 100C100까지 해야한다.
    100C50의 경우만 해도 매우 큰 경우의 수가 발생한다.

    그래서 DP를 이용해야 한다.
    N                       경우의 수
    N = 1 // A	            0, A
    N = 2 // A, B	        0, A, 0+B, A+B
    N = 3 // A, B, C	    0, A, B, A+B, 0+C, A+C, B+C, A+B+C

    새로운 수가 추가 될 때마다 기존 SET에 있던 모든 숫자들과 서로 더해주면 해결 가능하다.
 */

/*
    static void scoreSelect(int num) {
        Set<Integer> tmpSet = new HashSet<Integer>();
        tmpSet.addAll(set);
        Iterator<Integer> it = tmpSet.iterator();
        while(it.hasNext()) {
            set.add(it.next()+num);
        }
    }
 */
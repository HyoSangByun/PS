package Sorting_Searching.baekjoon;

import java.util.*;

/*
    Ex_2750과 유사하나 시간 복잡도가 O(nlogn)인 정렬 알고리즘으로 풀 수 있습니다.
    예를 들면 병합 정렬, 힙 정렬 등이 있지만, 어려운 알고리즘이므로 지금은 언어에 내장된 정렬 함수를 쓰는 것을 추천드립니다.
    Arrays.sort()도 시간 초과가 발생한다.

    이 문제는 되도록 Collections.sort를 사용하라는 문제이다.
    카운팅 정렬은 10989 문제에서 다룬다.

    그리고, 주의해야할 것이 스캐너를 사용한다면 출력할시에 System.out.println을 반복적으로 하는 것이 아니라
    StringBuilder를 사용해야 시간내를 만족한다.
 */
public class Ex_2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        for (Integer i : list) {
            System.out.println(i);
        }
    }

}

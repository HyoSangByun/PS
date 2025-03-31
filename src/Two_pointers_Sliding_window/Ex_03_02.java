package Two_pointers_Sliding_window;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Ex_03_02 { //공통원소 구하기 (two pointers  알고리즘) !time exceed
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set1.add(sc.nextInt());
        }

        int m = sc.nextInt();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set2.add(sc.nextInt());
        }

        // 교집합 구하기
        set1.retainAll(set2);

        // 결과를 오름차순으로 정렬하여 출력
        ArrayList<Integer> result = new ArrayList<>(set1);
        result.sort(null);

        for (Integer num : result) {
            System.out.print(num + " ");
        }

    }
}

// 중요! ArrayList.contains() 는 O(n)의 시간 복잡도를 가지므로 두 배열을 비교하면 O(n^2)의 시간 복잡도가 된다.

/*
각 입력 받은 배열을 오름차순 정렬시키고
arr1의 값이 arr2의 값보다 작으면 p1을 증가시키고 또 비교
 */
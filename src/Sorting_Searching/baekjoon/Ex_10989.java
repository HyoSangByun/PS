package Sorting_Searching.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);
    }
}
/*
    수의 범위가 작다면 카운팅 정렬을 사용하여 더욱 빠르게 정렬할 수 있습니다.
    다만, 시간과 메모리 제한이 빡빡하다보니 Collections.sort 를 사용하기 위한 객체(리스트 타입)들은 사용하진 못하고,
    입출력도 BufferedReader 와 StringBuilder 혹은 BufferedWriter 을 써야한다는 점이 중요했던 것 같다.
 */
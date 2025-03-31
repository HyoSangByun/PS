package Swea;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static int N, max;
    static Set<String> visited;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String next = sc.next();
            N = sc.nextInt();

            max = Integer.MIN_VALUE;
            visited = new HashSet<>();
            DFS(next, 0);

            System.out.println("#" + test_case + " " + max);
        }
    }

    static void DFS(String number, int count) {
        // 교환 횟수가 N에 도달하면 최대값 갱신
        if (count == N) {
            int parseInt = Integer.parseInt(number);
            max = Math.max(max, parseInt);
            return;
        }

        // 현재 상태를 방문한 적이 있는지 확인 (number + count를 상태로 저장)
        String state = number + "," + count;
        if (visited.contains(state)) {
            return;  // 이미 방문한 상태면 탐색 중지
        }

        // 현재 상태를 방문한 것으로 표시
        visited.add(state);

        // 중복된 상태를 피하기 위한 탐색
        for (int i = 0; i < number.length(); i++) {
            for (int j = i + 1; j < number.length(); j++) {
                // i와 j의 자리를 교환
                char[] numArray = number.toCharArray();
                char temp = numArray[i];
                numArray[i] = numArray[j];
                numArray[j] = temp;

                // 새로운 문자열로 DFS 탐색
                String newNumber = new String(numArray);
                DFS(newNumber, count + 1);
            }
        }
    }
}

/*
    맨 앞자리 숫자부터 맨뒤에서 앞으로 가면서(i+1까지) 자기보다 작은게 있다면 count ++해주고
    제일 큰 숫자의 뒤에서 count번쨰와 스왑

    DFS와 브루트포스로 모든 경우의 수를 구해서 최댓값을 출력하도록
 */
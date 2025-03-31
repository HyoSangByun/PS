package Implement;

import java.util.Scanner;

public class Ex_11723 {
    static StringBuilder sb = new StringBuilder();
    static int[] S = new int[21];
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String nextLine = sc.nextLine();
            stack(nextLine);
        }

        System.out.println(sb.toString());
    }

    private static void stack(String in) {
        if (in.startsWith("add")) {
            String[] parts = in.split(" ");
            Integer i = Integer.valueOf(parts[1]);
            S[i] = i;
        } else if (in.startsWith("remove")) {
            String[] parts = in.split(" ");
            Integer i = Integer.valueOf(parts[1]);
            S[i] = 0;
        } else if (in.startsWith("check")) {
            String[] parts = in.split(" ");
            Integer i = Integer.valueOf(parts[1]);
            if (S[i] == 0) sb.append(0).append('\n');
            else sb.append(1).append('\n');
        } else if (in.startsWith("toggle")) {
            String[] parts = in.split(" ");
            Integer i = Integer.valueOf(parts[1]);
            if (S[i] == 0) S[i] = i;
            else S[i] = 0;
        } else if (in.equals("all")) {
            for (int i = 1; i <= 20; i++) {
                S[i] = i;
            }
        } else if (in.equals("empty")) {
            for (int i = 1; i <= 20; i++) {
                S[i] = 0;
            }
        }
    }
}

/*
add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
all: S를 {1, 2, ..., 20} 으로 바꾼다.
empty: S를 공집합으로 바꾼다.
 */
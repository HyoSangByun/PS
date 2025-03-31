package Implement;

import java.util.Scanner;

public class Ex_2607 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String first = sc.next();
        int[] ch = new int[26]; // 기준 단어의 알파벳 빈도수 저장
        int answer = 0;

        for (int i = 0; i < first.length(); i++) {
            ch[first.charAt(i) - 'A']++;
        }

        for (int i = 0; i < N - 1; i++) {
            String next = sc.next();
            int[] nextCh = new int[26];

            for (int j = 0; j < next.length(); j++) {
                nextCh[next.charAt(j) - 'A']++;
            }

            // 문자 개수 차이 계산
            int diff = 0;
            for (int k = 0; k < 26; k++) {
                diff += Math.abs(ch[k] - nextCh[k]);
            }

            // 조건: 교체(2), 추가(1), 삭제(1) 허용
            if (diff == 0 || diff == 1 || (diff == 2 && Math.abs(first.length() - next.length()) <= 1)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}

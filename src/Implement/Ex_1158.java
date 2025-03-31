package Implement;

import java.util.Scanner;

public class Ex_1158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] answer = new int[N + 1];
        boolean[] ch = new boolean[N + 1];

        int count = 0; //뽑은 인원 수
        int i = 1; //뽑을 사람
        int time = 1; //몇번째인지 추적

        while (true) {
            if (count == N) break;

            if (time < K && !ch[i]) {
                time++;
            }
            else if (time == K && !ch[i]) {
                answer[count] = i;
                ch[i] = true;
                time = 1;
                count++;
            }

            if ( i == N ) i = 1;
            else {
                i++;
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for (int j = 0; j < answer.length - 2; j++) {
            sb.append(answer[j]);
            sb.append(", ");
        }
        sb.append(answer[answer.length - 2]);
        sb.append('>');

        System.out.println(sb.toString());
    }

}

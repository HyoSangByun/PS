package greedy.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_30805 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        //각 현재까지의 pointer를 기록하는 변수 생성
        int ap = 0;
        int bp = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int value = 100; value >= 1; value--) {
            int a, b;
            int aCount = 0;
            int bCount = 0;
            boolean foundA = false;
            boolean foundB = false;

            for(a = ap ; a < N ; ++a) {
                if(A[a] == value) {
                    foundA = true;
                    aCount++;
                }
            }

            for(b = bp ; b < M ; ++b) {
                if(B[b] == value) {
                    foundB = true;
                    bCount++;
                }
            }

            if(foundA && foundB) {
                int min = Math.min(aCount, bCount);
                for (int i = 0; i < min; i++) { //일단 겹치는 만큼 넣음
                    list.add(value);
                }

                //큰 값부터 탐색하므로 포인터의 위치를 조정하여 제일 큰 값 뒤에서부터 탐색하게끔
                ap = N;
                bp = M;
                while(aCount >= min) {
                    ap--;
                    if(A[ap] == value) aCount--;
                }
                while(bCount >= min) {
                    bp--;
                    if(B[bp] == value) bCount--;
                }
            }
        }

        sb.append(list.size()).append('\n');
        for (Integer i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }

}

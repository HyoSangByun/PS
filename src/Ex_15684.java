import java.util.Scanner;

public class Ex_15684 {

    static int N, M, H;
    static boolean[][] ladders;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt(); //기존 가로선
        H = sc.nextInt(); //총 가로선

        ladders = new boolean[H - 1][N - 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ladders[a - 1][b - 1] = true;
        }

        int answer = 0;
        for (int i = 0; i < N - 2; i++) {
            int count = 0;
            for (int j = 0; j < H - 2; j++) {
                if (ladders[j][i]) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                answer++;
            }

        }
    }

    private static void dfs() {

    }
}
/*
    각 열에 대하여 체크가 0개나 짝수개면 된다?
 */
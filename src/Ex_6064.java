import java.util.Scanner;

public class Ex_6064 { //수학 문제임

    static int N, M,x, y;
    static boolean[][] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            ch = new boolean[N + 1][M + 1];
            System.out.println(find(0, 0, 0));
        }
    }

    private static int find(int curX, int curY, int L) {
        if (curX == x && curY == y) return L;
        if (curX == N && curY == M) return -1;

        int nx = 0;
        int ny = 0;
        if (curX < N) nx = curX + 1;
        else {
            nx = 1;
        }
        if (curY < M) ny = curY + 1;
        else ny = 1;
        if (!ch[nx][ny]) {
            ch[nx][ny] = true;
        } else return -1;

        return find(nx, ny, L + 1);

    }
}

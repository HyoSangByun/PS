import java.util.Scanner;

public class Ex_12100 {
    static class Box {
        private int value;
        private boolean add;

        public Box(int value, boolean add) {
            this.value = value;
            this.add = add;
        }
    }

    static int N;
    static Box arr[][];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; //위 오른쪽 아래 왼쪽

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new Box[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = new Box(sc.nextInt(), false);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {

            }
        }
    }

    private static void bfs() {

    }

}

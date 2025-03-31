import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_20056 {
    static class Fireball {
        private int x;
        private int y;
        private int m;
        private int s;
        private int d;

        public Fireball(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N, M, K;
    static Queue<Fireball> queue = new LinkedList<>();
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int m = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();

            queue.offer(new Fireball(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            //이동
            moving();
            adding();
        }

        int sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll().m;
        }

        System.out.println(sum);
    }

    private static void moving() {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Fireball poll = queue.poll();
            int nx = poll.x + poll.s * dx[poll.d];
            int ny = poll.y + poll.s * dy[poll.d];

            while (nx < 0) {
                nx += N;
            }
            nx %= N;

            while (ny < 0) {
                ny += N;
            }
            ny %= N;

            queue.offer(new Fireball(nx, ny, poll.m, poll.s, poll.d));
        }
    }

    private static void adding() {
        Queue<Fireball> newQueue = new LinkedList<>();
        Fireball[][] map = new Fireball[N][N];
        int[][] ch = new int[N][N];

        while (!queue.isEmpty()) {
            Fireball poll = queue.poll();

            if (map[poll.x][poll.y] == null ) {
                map[poll.x][poll.y] = poll;
            } else {
                Fireball existing = map[poll.x][poll.y];
                int newD = 0;
                if ((existing.d == -1 && poll.d %2 == 1) || ( existing.d % 2 == 1 && poll.d % 2 == 1)) {
                    //모두 홀수
                    newD = -1;
                } else if ((existing.d % 2 == 0 && poll.d % 2 == 0)) {
                    //모두 짝수
                    newD = -2;
                } else {
                    newD = -3;
                }
                map[poll.x][poll.y] = new Fireball(poll.x, poll.y, existing.m + poll.m,
                    existing.s + poll.s,
                    newD);
                ch[poll.x][poll.y]++; //합쳐진 걸 표시
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ch[i][j] > 0) { //합쳐진 경우
                    Fireball fireball = map[i][j];
                    int newM = fireball.m / 5;
                    if (newM == 0) continue;
                    int newS = fireball.s / (ch[i][j] + 1);
                    if (fireball.d == -3) {
                        newQueue.offer(new Fireball(i, j, newM, newS, 1));
                        newQueue.offer(new Fireball(i, j, newM, newS, 3));
                        newQueue.offer(new Fireball(i, j, newM, newS, 5));
                        newQueue.offer(new Fireball(i, j, newM, newS, 7));
                    } else {
                        newQueue.offer(new Fireball(i, j, newM, newS, 0));
                        newQueue.offer(new Fireball(i, j, newM, newS, 2));
                        newQueue.offer(new Fireball(i, j, newM, newS, 4));
                        newQueue.offer(new Fireball(i, j, newM, newS, 6));
                    }
                }
                if (ch[i][j] == 0 && map[i][j] != null) { //안합쳐진 경우
                    newQueue.offer(map[i][j]);
                }
            }
        }

        queue = newQueue;
    }

}

package DFS_BFS_Utilization.Baekjoon.BFS;
import java.util.*;

public class Ex_19238 {
    static int N, M;
    static int[][] map;
    static Map<Point, Point> customerList = new HashMap<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    static class Passenger {
        Point p;
        int dist;

        public Passenger(Point p, int dist) {
            this.p = p;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int gas = sc.nextInt();

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        //운전자 좌표
        Point taxi = new Point(sc.nextInt() - 1, sc.nextInt() - 1);

        //손님들 정보
        for (int i = 0; i < M; i++) {
            customerList.put(new Point(sc.nextInt() - 1, sc.nextInt() - 1), new Point(sc.nextInt() - 1, sc.nextInt() - 1));
        }

        while (!customerList.isEmpty()) {
            // 1단계: 가장 가까운 손님 BFS로 탐색
//            System.out.println("taxi.x + \", \" + taxi.y = " + taxi.x + ", " + taxi.y);
            Passenger closestPassenger = findClosestPassenger(taxi);
//            System.out.println("closestPassenger = " + closestPassenger);

            // if (손님까지 도달 불가) return -1;
            if (closestPassenger == null || closestPassenger.dist > gas) {
                System.out.println(-1);
                return;
            }
            gas -= closestPassenger.dist;

            // 2단계: 손님 목적지까지 BFS로 탐색
            Point endPoint = customerList.get(closestPassenger.p);

            int moveToDestination = moveToDestination(closestPassenger.p, endPoint);
//            System.out.println("moveToDestination = " + moveToDestination);

            if (moveToDestination == -1 || moveToDestination > gas) {
                System.out.println(-1);
                return;
            }

            // 3단계: 연료 충전 및 손님 제거
            gas += moveToDestination;
            customerList.remove(closestPassenger.p);
            taxi = endPoint;
        }

        System.out.println(gas);
    }

    static Passenger findClosestPassenger(Point taxiStart) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        List<Passenger> passengerCandidates = new ArrayList<>();

        int distance = 0;
        q.offer(taxiStart);
        visited[taxiStart.x][taxiStart.y] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point p = q.poll();

                if (customerList.containsKey(p)) {
                    passengerCandidates.add(new Passenger(p, distance));
                }

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (visited[nx][ny] || map[nx][ny] == 1) continue;

                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }

            if (!passengerCandidates.isEmpty()) {
                Collections.sort(passengerCandidates, (o1, o2) -> {
                    if (o1.p.x == o2.p.x) return o1.p.y - o2.p.y;
                    return o1.p.x - o2.p.x;
                });
                return passengerCandidates.get(0);
            }
            distance++;
        }

        return null;
    }

    // 손님 목적지까지 BFS로 탐색
    static int moveToDestination(Point start, Point end) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        q.offer(start);
        visited[start.x][start.y] = true;
        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point poll = q.poll();

                if (poll.x == end.x && poll.y == end.y) {
                    return distance;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = poll.x + dx[k];
                    int ny = poll.y + dy[k];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (visited[nx][ny] || map[nx][ny] == 1) continue;

                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }

            distance++;
        }

        return -1;
    }
}

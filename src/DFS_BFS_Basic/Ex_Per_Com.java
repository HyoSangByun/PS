package DFS_BFS_Basic;

public class Ex_Per_Com {
    static int N = 3, M = 2;
    static boolean visited[];
    static int[] arr;

    public static void main(String[] args) {
        visited = new boolean[N + 1];
        arr = new int[N + 1];

        //순열
        //Per(0);

        //조합
        //Com(0, 1);

        //중복 순열
        //DupPer(0);

        //중복 조합
        PerCom(0, 1);
    }

    static void Per(int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    arr[count] = i;
                    Per(count + 1);
                    visited[i] = false;
                }
            }
        }

    }

    static void Com(int count, int start) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[count] = i;
                Com(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static void DupPer(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i; //중복 허용 -> visited 검사 안함
            DupPer(depth + 1);
        }
    }

    static void PerCom(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            PerCom(depth + 1, i);  // 중복 허용: i부터 다시 탐색
        }
    }
}

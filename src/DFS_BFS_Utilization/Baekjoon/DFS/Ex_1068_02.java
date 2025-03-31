package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.*;

public class Ex_1068_02 { //백준 1068
    static int N, K, count = 0;
    static List<Integer>[] tree;
    static boolean[] isDeleted;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new ArrayList[N];
        isDeleted = new boolean[N];
        int root = -1;

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>(); //노드별로 arraylist 생성
        }

        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i); //부모 노드에 노드 넣음
            }
        }

        K = sc.nextInt();
        isDeleted[K] = true;  // K 노드를 삭제

        if (root != K) { //트리노드가 삭제노드가 아니라면 DFS
            DFS(root);
        }

        System.out.println(count);
    }

    private static void DFS(int node) {
        // 노드가 삭제되었으면 바로 종료
        if (isDeleted[node]) return;

        boolean isLeaf = true;
        for (int child : tree[node]) {
            if (!isDeleted[child]) {
                isLeaf = false;
                DFS(child);
            }
        }
        if (isLeaf) count++;
    }
}
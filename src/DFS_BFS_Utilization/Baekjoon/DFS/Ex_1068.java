package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.*;

public class Ex_1068 { //백준 1068
    static int N, K, count = 0;
    static List<Node> list = new ArrayList<>();

    static class Node {
        private int value;
        private Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private static void BFS(Node node) {
        Queue<Node> Q = new LinkedList<>();
        if (node == null || node.value == -1) return;
        Q.offer(node);

        while (!Q.isEmpty()) {
            Node pollNode = Q.poll();

            if (pollNode.left == null && pollNode.right == null) count++;
            if (pollNode.left != null) Q.offer(pollNode.left);
            if (pollNode.right != null) Q.offer(pollNode.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i);
        }

        int root = -1;

        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            if (parent == -1) {
                root = i;
            } else {
                if (nodes[parent].left == null) {
                    nodes[parent].left = nodes[i];
                } else {
                    nodes[parent].right = nodes[i];
                }
            }
        }

        K = sc.nextInt();
        nodes[K].value = -1;

        if (root != K) {
            BFS(nodes[root]);
        }

        System.out.println(count);
    }
}
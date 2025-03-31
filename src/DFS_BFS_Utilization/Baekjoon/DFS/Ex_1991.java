package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.Scanner;

public class Ex_1991 {
    static class Node {
        private char value;
        private Node left;
        private Node right;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static int N;
    static Node[] trees;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        trees = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            char parent = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);
            if (trees[parent - 'A'] == null) { // 부모 노드가 아직 생성되지 않은 경우. 'A'는 문자 'A'의 ASCII 값
                trees[parent - 'A'] = new Node(parent); // 부모 노드를 생성
            }
            if (left != '.') { // 왼쪽 자식이 존재할 경우
                trees[left - 'A'] = new Node(left); // 왼쪽 자식 노드를 생성
                trees[parent - 'A'].left = trees[left - 'A']; // 부모 노드와 연결
            }
            if (right != '.') { // 오른쪽 자식이 존재할 경우
                trees[right - 'A'] = new Node(right); // 오른쪽 자식 노드를 생성
                trees[parent - 'A'].right = trees[right - 'A']; // 부모 노드와 연결
            }
        }

        // 전위 순회
        preorder(trees[0]);
        System.out.println();

        // 중위 순회
        inorder(trees[0]);
        System.out.println();

        // 후위 순회
        postorder(trees[0]);
        System.out.println();

    }

    private static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    private static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    // 후위 순회
    private static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

}

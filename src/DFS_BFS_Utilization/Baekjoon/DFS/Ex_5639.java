package DFS_BFS_Utilization.Baekjoon.DFS;

import java.util.Scanner;

public class Ex_5639 {

    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int val) {
            if (val < value) {
                if (left == null) {
                    left = new Node(val);
                } else {
                    left.insert(val);
                }
            } else {
                if (right == null) {
                    right = new Node(val);
                } else {
                    right.insert(val);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = null;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) break; // 빈 줄이 입력되면 종료
            int value = Integer.parseInt(line.trim());
            if (root == null) {
                root = new Node(value); // 첫 값을 루트로 설정
            } else {
                root.insert(value); // 트리에 삽입
            }
        }

        // 후위 순회 결과 출력
        if (root != null) {
            postOrder(root);
        }
    }

    private static void postOrder(Node node) {
        if (node == null) return; // 종료 조건
        postOrder(node.left);    // 왼쪽 서브트리 탐색
        postOrder(node.right);   // 오른쪽 서브트리 탐색
        System.out.println(node.value); // 루트 출력
    }
}

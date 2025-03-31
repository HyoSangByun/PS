package DFS_BFS_Basic;

import java.util.Scanner;

//루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이(edge의 갯수)를 구하시오
public class Ex_07_09 { //Tree 말단노드까지의 가장 짧은 경로 (DFS)
    static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(DFS(0, root));
    }

    public static int DFS(int L, Node root) {
        if ( root.lt == null && root.rt == null ) return L;
        else return Math.min(DFS(L + 1, root.lt), DFS(L+1, root.rt));
    }
}
/*
    모든 노드 탐색
 */

package DFS_BFS_Basic;

import java.util.LinkedList;
import java.util.Queue;

//이진트리를 레벨탐색하시오 레벨별 출력
public class Ex_07_07 { //이진트리 레벨탐색(BFS: Breadth-First Search)

    static int n;
    static int[] ch;

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
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        BFS(root);
    }

    public static void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) Q.offer(cur.lt);
                if (cur.rt != null) Q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

}
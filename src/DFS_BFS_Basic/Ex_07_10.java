package DFS_BFS_Basic;

import java.util.LinkedList;
import java.util.Queue;

//루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이(edge의 갯수)를 구하시오
public class Ex_07_10 { //Tree 말단노드까지의 가장 짧은 경로 (BFS)
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
        System.out.println(BFS(root));
    }

    public static int BFS( Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                if (cur.lt == null && cur.rt == null) return L;
                if (cur.lt != null) Q.offer(cur.lt);
                if (cur.rt != null) Q.offer(cur.rt);
            }
            L++;
        }
        return -1;
    }
}

/*
    레벨별로 최단거리 확인하다가 조건만족하면 반환
 */
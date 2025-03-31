package DFS_BFS_Basic;

//이진트리를 전위순회와 후위순회로 연습해보자 !!노트로 스택 프레임을 그려보며 이해하자
public class Ex_07_05 { //이진트리순회(DFS : Depth-First Search)

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
        DFS(root);
    }

    public static void DFS(Node root) {
        if(root == null) return;
        else { //중위순회
            System.out.print(root.data + " ");
            DFS(root.lt);
            DFS(root.rt);
        }
    }

}

/*
        else { //중위순회
            DFS(root.lt);
            System.out.print(root.data + " ");
            DFS(root.rt);
        }
        else { //후위순회
            DFS(root.lt);
            DFS(root.rt);
            System.out.print(root.data + " ");
        }
        else { //전위순회
            System.out.print(root.data + " ");
            DFS(root.lt);
            DFS(root.rt);
        }
 */
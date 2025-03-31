package DFS_BFS_Basic;

//자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요
public class Ex_07_06 { //이진트리순회(DFS : Depth-First Search)

    static int n;
    static int[] ch;

    public static void main(String[] args) {
        n = 3;
        ch = new int[n + 1];
        DFS(1);
    }

    public static void DFS(int L) {
        if(L == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) tmp +=(i+ " ");
            }
            if (tmp.length()>0) System.out.println(tmp);
        } else {
            ch[L]=1;
            DFS(L+1);
            ch[L]=0;
            DFS(L+1);
        }
    }

}

/*
    배열에 저장하면서 리턴하면 더 빠른 성능을 보인다.
    중복계산을 피할수있다

    메모이제이션이란 동일한 계산을 반복하지 않도록 계산된 값을 저장해두는 최적화 기법이다.
 */
package greedy;

public class Ex_09_05 {
}

/*
    다익스트라 알고리즘
    1차원 배열을 모두 Max 값으로 초기화함
    그 후 출발점을 0으로 설정

    이제는 아래를 반복함

    1.배열에서 최솟값을 visited 체크함
    2.visitided 체크한 곳에서 갈 수 있는 정점에 최소값으로 갱신함
    최솟값이 Max 값이라면 안 감

    O(n) 시간복잡도임
    단, 간선의 가중치가 0이상이어야함
 */

/*
    import java.util.*;
class Edge implements Comparable<Edge>{
    public int vex;
	public int cost;
    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost-ob.cost;
    }
}

class Main {
	static int n, m;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;
	public void solution(int v){
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(v, 0));
		dis[v]=0;
		while(!pQ.isEmpty()){
			Edge tmp=pQ.poll();
			int now=tmp.vex;
			int nowCost=tmp.cost;
			if(nowCost>dis[now]) continue;
			for(Edge ob : graph.get(now)){
				if(dis[ob.vex]>nowCost+ob.cost){
					dis[ob.vex]=nowCost+ob.cost;
					pQ.offer(new Edge(ob.vex, nowCost+ob.cost));
				}
			}
		}
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n=kb.nextInt();
		m=kb.nextInt();
		graph = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<=n; i++){
			graph.add(new ArrayList<Edge>());
		}
		dis=new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		for(int i=0; i<m; i++){
			int a=kb.nextInt();
			int b=kb.nextInt();
			int c=kb.nextInt();
			graph.get(a).add(new Edge(b, c));
		}
		T.solution(1);
		for(int i=2; i<=n; i++){
			if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
			else System.out.println(i+" : impossible");
		}
	}
}
 */
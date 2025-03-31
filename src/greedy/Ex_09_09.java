package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex_09_09 { //원더랜드 (최소 스패닝 트리 - '프림' , PriorintyQueue)
    static int[] ch;

    static class Edge implements Comparable<Edge> {
        private int vex;
        private int cost;
        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        ch=new int[n+1];
        for(int i=0; i<m; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        int answer=0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));
        while(!pQ.isEmpty()){
            Edge tmp=pQ.poll();
            int ev=tmp.vex;
            if(ch[ev]==0){
                ch[ev]=1;
                answer+=tmp.cost;
                for(Edge ob : graph.get(ev)){
                    if(ch[ob.vex]==0) pQ.offer(new Edge(ob.vex, ob.cost));
                }
            }
        }
        System.out.println(answer);

    }
}

/*
    '프림' , PriorintyQueue

    pq에 갈수 있는 정점을 넣고 갈 수(체크) 있으면 poll함
 */
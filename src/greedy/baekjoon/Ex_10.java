package greedy.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex_10 { //백준 16593
    static long N,M;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextLong();
        M = sc.nextLong();

        System.out.println(BFS(N));
    }

    static long BFS(long a) {
        Queue<Long> q = new LinkedList<>();
        q.add(a);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                long tmp = q.poll();
                if(tmp==M)
                    return cnt+1;

                if(tmp*2<=M) q.add(tmp*2);
                if(tmp*10+1<=M) q.add(tmp*10+1);
            }
            cnt++;
        }
        return -1;
    }
}
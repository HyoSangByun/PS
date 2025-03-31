package greedy.baekjoon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ex_1043 { //유니온-파인드

    static int N, M;
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> partyList = new ArrayList<>();
        N = sc.nextInt();
        M = sc.nextInt();

        //초기화
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            partyList.add(new ArrayList<>());
        }

        int known = sc.nextInt(); //거짓말인지 아닌지 아는 사람
        for (int i = 0; i < known; i++) {
            set.add(sc.nextInt());
        }

        for (int i = 0; i < M; i++) {
            List<Integer> party = partyList.get(i);
            int peopleCount = sc.nextInt(); //파티 사람 수
            int first = sc.nextInt(); //파티 첫번째 사람
            party.add(first);
            for (int j = 0; j < peopleCount - 1; j++) {
                int nextPerson = sc.nextInt();
                party.add(nextPerson);
                union(first, nextPerson);
            }
        }

        Set<Integer> updatedSet = new HashSet<>();
        for (int person : set) {
            updatedSet.add(find(person));
        }
        set.addAll(updatedSet);

        int answer = M;
        for (List<Integer> party : partyList) {
            for (int person : party) {
                if (set.contains(find(person))) {
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX <= rootY) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
    }
}

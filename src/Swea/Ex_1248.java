package Swea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Ex_1248 {

    static List<List<Integer>> toParentList;
    static List<List<Integer>> toChildList;
    static int V, E;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            V = sc.nextInt();
            E = sc.nextInt();

            int startVertex1 = sc.nextInt();
            int startVertex2 = sc.nextInt();

            toParentList = new ArrayList<>();
            toChildList = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                toParentList.add(new ArrayList<>());
                toChildList.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int parent = sc.nextInt();
                int child = sc.nextInt();

                toChildList.get(parent).add(child);
                toParentList.get(child).add(parent);
            }

            int commonParent = findCommonParent(startVertex1, startVertex2);

            int subtreeSize = findSubtreeSize(commonParent);

            System.out.println("#" + t + " " + commonParent + " " + subtreeSize);

        }
    }

    private static int findSubtreeSize(int commonParent) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(commonParent);

        int size = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            size++;

            for (Integer i : toChildList.get(poll)) {
                queue.offer(i);
            }
        }

        return size;
    }

    private static int findCommonParent(int startVertex1, int startVertex2) {
        List<Integer> find = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex1);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer i : toParentList.get(poll)) {
                find.add(i);
                queue.offer(i);
            }
        }

        queue.offer(startVertex2);

        int commonParent = 1;
        boolean flag = false;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer i : toParentList.get(poll)) {
                if (find.contains(i)) {
                    commonParent = i;
                    flag = true;
                    break;
                }
                queue.offer(i);
            }

            if (flag) { break;}
        }

        return commonParent;
    }

}

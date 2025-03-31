package Sorting_Searching.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex_11650 {
    static class Position implements Comparable<Position>{
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position o) {
            if (this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Position> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new Position(x, y));
        }

        Collections.sort(list);

        for (Position position : list) {
            System.out.println(position.x + " " + position.y);
        }
    }
}

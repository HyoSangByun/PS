package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Ex_09_03_02 { //결혼식 !time limit
    static class Time implements Comparable<Time> {
        private int time;
        private char type;

        public Time(int time, char type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.time) return this.type - o.type;
            else return this.time - o.time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            list.add(new Time(start, 's'));
            list.add(new Time(end, 'e'));
        }

        Collections.sort(list);

        int count =0,max = 0;
        for (Time time : list) {
            if (time.type == 'e') count--;
            else count ++;

            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
/*
    5 14
    12 15
    14 18
    15 20
    20 30
 */
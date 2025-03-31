package greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_09_02 { //회의실 배정
    static class Time implements Comparable<Time> {
        private int s;
        private int e;

        public Time(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Time o) {
            if (this.e == o.e) return this.s - o.s;
            else return this.e - o.e;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new Time(s, e));
        }

        list.sort(null);

        int count = 0;
        int endTime = 0;
        for (Time time : list) {
            if (time.s >= endTime) {
                count++;
                endTime = time.e;
            }
        }

        System.out.println(count);
    }
}

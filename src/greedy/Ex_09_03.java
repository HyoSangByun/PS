package greedy;

import java.util.*;

public class Ex_09_03 { //결혼식 !time limit
    static class Time implements Comparable<Time> {
        private int start;
        private int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if (this.start == o.start) return this.end - o.end;
            else return this.start - o.start;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            list.add(new Time(start, end));
        }

        list.sort(null);

        ArrayList<Time> answer = new ArrayList<>();
        answer.add(list.get(0));
        int max = 0;

        for (int i = 1; i < n; i++) {
            Time time = list.get(i);
            if (answer.isEmpty()) answer.add(time);

            Iterator<Time> iterator = answer.iterator();
            while (iterator.hasNext()) {
                Time playing = iterator.next();
                if (time.start >= playing.end) {
                    iterator.remove();
                }
            }


            if (!answer.isEmpty() && answer.get(0).end> time.start) answer.add(time);
            max = Math.max(answer.size(), max);
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
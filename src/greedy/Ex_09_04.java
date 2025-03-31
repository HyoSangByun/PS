package greedy;

import java.util.*;

public class Ex_09_04 { //최대 수입 스케쥴(PriorityQueue 응용문제)
    static class Lecture implements Comparable<Lecture> {
        private int money;
        private int time;

        public Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.time - this.time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int days = Integer.MIN_VALUE;
        ArrayList<Lecture> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int time = sc.nextInt();

            days = Math.max(days, time);
            list.add(new Lecture(money, time));
        }

        Collections.sort(list);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        int j = 0;

        for (int i = days; i > 0; i--) {
            for ( ; j < n; j++) {
                if (list.get(j).time < i) break;
                pQ.offer(list.get(j).money);
            }

            if (!pQ.isEmpty()) {
                int oo = pQ.poll();
                sum += oo;
            }
        }

        System.out.println(sum);
    }
}

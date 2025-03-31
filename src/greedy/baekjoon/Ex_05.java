    package greedy.baekjoon;

    import java.util.*;

    public class Ex_05 { //백준 1202 !time limit

        static class Apple implements Comparable<Apple> {
            private int weight;
            private int pay;

            public Apple(int weight, int pay) {
                this.weight = weight;
                this.pay = pay;
            }

            @Override
            public int compareTo(Apple o) {
                if (o.pay == this.pay) return this.weight - o.weight;
                else return o.pay - this.pay;
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            PriorityQueue<Apple> pQ = new PriorityQueue<>();
            PriorityQueue<Integer> bag = new PriorityQueue<>(Collections.reverseOrder());

            int N = sc.nextInt();
            int K = sc.nextInt();

            for (int i = 0; i < N; i++) {
                int weight = sc.nextInt();
                int pay = sc.nextInt();

                pQ.offer(new Apple(weight, pay));
            }

            for (int i = 0; i < K; i++) {
                bag.offer(sc.nextInt());
            }

            int sum = 0;
            int bagSize = bag.poll();
            while (!pQ.isEmpty()) {
                Apple apple = pQ.poll();
                if (bagSize >= apple.weight) {
                    sum += apple.pay;
                    if (!bag.isEmpty()) bagSize = bag.poll();
                    else break;
                }
            }

            System.out.println(sum);
        }
    }
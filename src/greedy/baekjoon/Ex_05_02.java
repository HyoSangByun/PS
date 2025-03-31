    package greedy.baekjoon;

    import java.util.*;

    public class Ex_05_02 { //백준 1202

        static class Apple implements Comparable<Apple> {
            private int weight;
            private int pay;

            public Apple(int weight, int pay) {
                this.weight = weight;
                this.pay = pay;
            }

            @Override
            public int compareTo(Apple o) {
                if (o.weight == this.weight) return o.pay - this.pay;
                else return this.weight - o.weight;
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ArrayList<Apple> appleList = new ArrayList<>();
            ArrayList<Integer> bags = new ArrayList<>();

            int N = sc.nextInt();
            int K = sc.nextInt();

            for (int i = 0; i < N; i++) {
                int weight = sc.nextInt();
                int pay = sc.nextInt();

                appleList.add(new Apple(weight, pay));
            }
            Collections.sort(appleList);

            for (int i = 0; i < K; i++) {
                bags.add(sc.nextInt());
            }
            Collections.sort(bags);

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            int j=0;
            long sum = 0;

            for (int i = 0;  i < K; i++) {
                while (j < N && appleList.get(j).weight <= bags.get(i)) {
                    pq.add(appleList.get(j++).pay); // 가방에 넣을 수 있는 모든 보석을 추가
                }

                if (!pq.isEmpty()) sum += pq.poll();
            }

            System.out.println(sum);
        }
    }

    /*
    가방에 보석을 넣을 때 큰 가방부터 탐색하면 작은 가방에 넣을 수 없는 경우가 발생합니다.
    가방을 오름차순으로 정렬하였기 때문에 보석도 무게가 낮은 것부터 탐색하고,
    가치의 최대값을 구해야하기 때문에 무게가 같을 때에는 가치가 높은 것을 먼저 탐색해야 합니다.

    1. 보석은 무게에 대해 오름차순 정렬하되, 무게가 같을 경우 가격에 대해 내림차순 정렬한다.
    2. 가방은 오름차순 정렬한다.
    3. 모든 가방에 대해서 반복문을 수행한다.
    3-1. 특정 가방의 무게보다 작은 보석의 가격을 모두 우선순위 큐에 집어넣는다. (이때, 우선순위 큐는 가격에 대해 내림차순 정렬을 해야한다.)
    3-2. 우선순위 큐가 비어있지 않다면, 우선순위 큐에서 맨 앞 요소를 하나 빼고 그 가격을 ans에 더한다.
     */
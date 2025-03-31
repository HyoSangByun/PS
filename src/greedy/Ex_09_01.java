package greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_09_01 { //씨름선수
    static class Body implements Comparable<Body>{
        private int height;
        private int weight;

        public Body(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Body o) {
            return o.height - this.height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Body> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();

            list.add(new Body(h, w));
        }

        list.sort(null);

        int count = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if(max < list.get(i).weight ) {
                max = list.get(i).weight;
                count++;
            }
        }

        System.out.println(count);
    }
}

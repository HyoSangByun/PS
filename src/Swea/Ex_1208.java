package Swea;

import java.util.*;

public class Ex_1208 {
    static class Land implements Comparable<Land> {
        private int index;
        private int height;

        public Land(int index, int height) {
            this.index = index;
            this.height = height;
        }

        @Override
        public int compareTo(Land o) {
            return this.height - o.height;
        }
    }
    static List<Land> landList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();

            for (int i = 0; i < 100; i++) {
                int height = sc.nextInt();
                landList.add(new Land(i, height));
            }


            for (int i = 0; i < N; i++) {
                dump();
            }

            System.out.println(landList.getLast().height - landList.getFirst().height);
        }
    }

    private static void dump() {
        Collections.sort(landList); //오름차순 정렬

        Land smallest = landList.get(0);//가장 높이가 작은 것
        Land tallest = landList.get(landList.size() - 1);

        landList.remove(0);
        landList.add(new Land(smallest.index, smallest.height + 1));

        landList.remove(landList.size() - 1);
        landList.add(new Land(tallest.index, tallest.height - 1));

    }
}

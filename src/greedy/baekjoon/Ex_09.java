package greedy.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex_09 { //백준 1946
    static class Person implements Comparable<Person>{
        private int test1;
        private int test2;

        public Person(int test1, int test2) {
            this.test1 = test1;
            this.test2 = test2;
        }

        @Override
        public int compareTo(Person o) {
            return this.test1 - o.test1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {

            int N = sc.nextInt();
            ArrayList<Person> list = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                int t1 = sc.nextInt();
                int t2 = sc.nextInt();

                list.add(new Person(t1, t2));
            }
            System.out.println(solution(list, N));

        }
    }

    static int solution(ArrayList<Person> list, int N) {
        Collections.sort(list);
        int maxScore = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int test2score = list.get(i).test2;

            if (test2score < maxScore) {
                maxScore = test2score;
                count++;
            }
        }

        return count;
    }
}

/*
    1 4
    2 3
    3 2
    4 1
    5 5
 */
package Implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex_7568 {
    static class Person {
        private int weight;
        private int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> list = new ArrayList<>();
        int N = sc.nextInt();
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            int weight = sc.nextInt();
            int height = sc.nextInt();

            list.add(new Person(weight, height));
        }

        for (int i = 0; i < N; i++) {
            int weight = list.get(i).weight;
            int height = list.get(i).height;
            int rank = 1;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                int jweight = list.get(j).weight;
                int jheight = list.get(j).height;
                if (weight < jweight && height < jheight) {
                    rank++;
                }
            }

            answer[i] = rank;
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
/*
88 180 1  5 - 1
60 175 1  5 - 1
58 183 1  5 - 1
55 185 1
46 155 5

위에서부터 탐색해서

5
88 180
60 175
58 183
55 185
46 155
 */
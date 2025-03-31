package Swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex_1983 {
    static class Student implements Comparable<Student> {
        private int name;
        private double score;

        public Student(int name, double score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return Double.compare(o.score, this.score);
        }
    }

    private static final List<String> output = Arrays.asList("A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Student> studentScore = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int midTest = sc.nextInt();
            int finalTest = sc.nextInt();
            int hw = sc.nextInt();

            double score = midTest * 0.35 + finalTest * 0.45 + hw * 0.2;
            studentScore.add(new Student(i, score));
        }

        Collections.sort(studentScore);

        for (int i = 0; i < N; i++) {
            if (studentScore.get(i).name == K) {
                int select = (int) (((double) i / N) * 100.0) / 10;
                System.out.println(output.get(select));
                break;
            }
        }
    }
}

/*
    자바 9이상은 List.of(...)가능하지만 자바 8이하에서는 Arrays.asList(...)를 사용해야한다.
    private static final List<String> output = Arrays.asList("A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0");
 */
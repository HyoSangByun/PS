package Implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex_1713 {
    static class Student implements Comparable<Student>{
        private int name;
        private int recommend;
        private int order;

        public Student(int name, int recommend, int order) {
            this.name = name;
            this.recommend = recommend;
            this.order = order;
        }

        @Override
        public int compareTo(Student o) {
            if (this.recommend == o.recommend)
                return this.order - o.order;
            else {
                return this.recommend - o.recommend;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int photo_size = sc.nextInt();
        int N = sc.nextInt();

        List<Student> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int inputName = sc.nextInt();

            boolean jump = false;
            for (Student student : list) { //이미 후보자에 있다면
                if (student.name == inputName) {
                    student.recommend += 1;
                    student.order = i;
                    jump = true;
                    break;
                }
            }

            if (jump) continue;

            if (list.size() < photo_size) {
                list.add(new Student(inputName, 1, i));
            } else {
                Collections.sort(list);
                list.remove(0);
                list.add(new Student(inputName, 1, i));
            }
        }

        Collections.sort(list);
        int[] answer = new int[photo_size];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).name;
        }
        Arrays.sort(answer);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}

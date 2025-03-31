package Sorting_Searching.baekjoon;

import java.util.*;

public class Ex_10814 {
    static class Person implements Comparable<Person> {
        private int age;
        private int order;
        private String name;

        public Person(int age, int order, String name) {
            this.age = age;
            this.order = order;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            if (this.age == o.age) return this.order - o.order;
            else return this.age - o.age;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Person> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            list.add(new Person(age, i, name));
        }

        Collections.sort(list);

        for (Person person : list) {
            System.out.println(person.age + " " + person.name);
        }
    }
}

package Sorting_Searching.baekjoon;

import java.util.*;

public class Ex_1181 {
    static class Alphabet implements Comparable<Alphabet>{
        private int size;
        private String letter;

        public Alphabet(int size, String letter) {
            this.size = size;
            this.letter = letter;
        }

        @Override
        public int compareTo(Alphabet o) {
            if (this.size == o.size) return this.letter.compareTo(o.letter);
            else return this.size - o.size;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Set<String> set = new HashSet<>();
        List<Alphabet> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }
        for (String string : set) {
            list.add(new Alphabet(string.length(), string));
        }

        Collections.sort(list);

        for (Alphabet alphabet : list) {
            System.out.println(alphabet.letter);
        }
    }
}

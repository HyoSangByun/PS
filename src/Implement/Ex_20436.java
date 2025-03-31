package Implement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex_20436 {
    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Map<Character, Point> s = new HashMap<>();
    static Map<Character, Point> v = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point L, R;
        int time = 0;
        addMap();

        L = s.get(sc.next().charAt(0));
        R = v.get(sc.next().charAt(0));

        char[] charArray = sc.next().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            Character c = charArray[i];
            if (s.containsKey(c)) {
                Point dir_L = s.get(c);
                time += Math.abs(L.x - dir_L.x) + Math.abs(L.y - dir_L.y) + 1;
                L = dir_L;
            } else if (v.containsKey(c)) {
                Point dir_R = v.get(c);
                time += Math.abs(R.x - dir_R.x) + Math.abs(R.y - dir_R.y) + 1;
                R = dir_R;
            }
        }

        System.out.println(time);
    }

    private static void addMap() {
        s.put('q', new Point(1, 1));
        s.put('w', new Point(1, 2));
        s.put('e', new Point(1, 3));
        s.put('r', new Point(1, 4));
        s.put('t', new Point(1, 5));
        s.put('a', new Point(2, 1));
        s.put('s', new Point(2, 2));
        s.put('d', new Point(2, 3));
        s.put('f', new Point(2, 4));
        s.put('g', new Point(2, 5));
        s.put('z', new Point(3, 1));
        s.put('x', new Point(3, 2));
        s.put('c', new Point(3, 3));
        s.put('v', new Point(3, 4));

        v.put('y', new Point(1, 6));
        v.put('u', new Point(1, 7));
        v.put('i', new Point(1, 8));
        v.put('o', new Point(1, 9));
        v.put('p', new Point(1, 10));
        v.put('h', new Point(2, 6));
        v.put('j', new Point(2, 7));
        v.put('k', new Point(2, 8));
        v.put('l', new Point(2, 9));
        v.put('b', new Point(3, 5));
        v.put('n', new Point(3, 6));
        v.put('m', new Point(3, 7));
    }
}

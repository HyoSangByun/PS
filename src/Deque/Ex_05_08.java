package Deque;

import java.util.*;

public class Ex_05_08 { //응급실 !못품
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        /*
            6 3
            70 60 90 60 60 60
            60 90 60 60 60 70
            90 60 60 60 70 60
            60 60 60 70 60
            ...
            70 60 60 60

         */
        Deque<Integer> list = new ArrayDeque<>();

        int key = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int nextInt = sc.nextInt();
            list.offer(nextInt);
            if (i == m) key = nextInt;
        }

        for (int i = 0; i < m; i++) { //0 ~ 2
            Integer removeFirst = list.removeFirst();
            if (!list.isEmpty() && removeFirst > key) count++;
            else if (removeFirst <= key) {
                list.offer(removeFirst);
            }
        }

        // '60' 60 60 60 count:2

        for (int i = list.size()-1; i > m; i--) { //4 ~ 3
            if (!list.isEmpty() && list.pollLast() >= key) count++;
        }

        System.out.println(count + 1);
    }
}


/*
    id와 priority를 갖는 person이라는 클래스를 만들어서 해결함


 */
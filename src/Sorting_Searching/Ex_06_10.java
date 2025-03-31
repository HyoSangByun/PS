package Sorting_Searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex_06_10 { //마구간 정하기 (결정알고리즘) !틀림
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);

        answerList.add(Collections.min(list));
        list.remove(Collections.min(list));

        answerList.add(Collections.max(list));
        list.remove(Collections.max(list));

        while ( answerList.size() < m) {
            int max = 10000;
            int saveInt = 0;
            Integer sum = (answerList.stream().reduce(0, Integer::sum)) / answerList.size();
            for (Integer i1 : list) {
                    if (Math.abs(sum - i1) < max) {
                        saveInt = i1;
                        max = Math.abs(sum - i1);
                    }
            }

            list.remove((Integer) saveInt);
            answerList.add(saveInt);
        }

        Collections.sort(answerList);
        int min = 100000;
        for (int i = 0; i < answerList.size() - 1; i++) {
            for (int j = i + 1; j < answerList.size(); j++) {
                if (answerList.get(j) - answerList.get(i) < min) {
                    min = answerList.get(j) - answerList.get(i);
                }
            }
        }

        System.out.println(min);
    }
}

/*
    lt : 9 - 1 = 8
    rt : 2 - 1 = 1

    거리마다 최대 배치 갯수를 결정 알고리즘으로 구함

 */
package Array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

// 문제 이해를 잘못함 다시 천천히 문제 이해하고 풀어보길
public class Ex_02_12 { //멘토링 !틀림
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //학생 수
        int m = sc.nextInt(); //시험 횟수

        Set<String> collections = new HashSet<>();

        for (int i = 0; i < m; i++) { //시험 횟수 만큼 반복문
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                list.add(sc.nextInt());
            } //list에 학생 등수 입력
//            System.out.println("list : " + list);

            //학생 루프 돌면서 뒤에 학생들을 짝으로 넣음
            for (int j = 1; j <= n; j++) { //시험 횟수 반복문
                int indexOf = list.indexOf(j); //j 학생의 등수
//                System.out.println(j + "의 indedOf는 " + indexOf);
                if (indexOf < n - 1) { //뒤에 학생이 있다면
                    for (int l = indexOf +1; l < n; l++) {
                        String s ="";
                        s = String.valueOf(j)+String.valueOf(list.get(l));
                        collections.add(s); //짝지어서 Set에 넣어줌
                    }
                }
            }
        }

        Set<String> answer = new HashSet<>();
        for (String s : collections) {
            String sb = new StringBuilder(s).reverse().toString();
            if ( !collections.contains(sb)) {
                answer.add(s);
            }
        }

        System.out.println(answer.size());

    }
}
/*
내가 푼 방식
        배열을 테스트 개수 만큼 만듦
        학생 수 루프를 돌면서 배열을 탐색하는데
        그 학생 뒤에 특정 학생이 있으면 짝으로 넣음
        그 후에 앞뒤를 뒤집어서 똑같은 경우에는 모두 삭제 해주고
        사이즈(경우의 수)를 출력함
        */

//12 14 21 31 32 34 41 42 43
//31 32 42

/*
문제 해설
    4중 포문을 해야함
    열을 등수 행을 테스트 횟수
    멘토 멘티 경우의수를 n * n으로 초기화함

 */
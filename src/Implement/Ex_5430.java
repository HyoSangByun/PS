package Implement;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Ex_5430 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            String command = sc.nextLine();
            int N = sc.nextInt();
            sc.nextLine();
            String arrayInput = sc.nextLine();

            // 배열 파싱
            Deque<Integer> deque = new LinkedList<>(); //여기에 숫자 배열 넣음
            arrayInput = arrayInput.substring(1, arrayInput.length() - 1);  // 대괄호 제거
            if (!arrayInput.isEmpty()) {  // 배열이 비어있지 않다면 파싱
                String[] elements = arrayInput.split(",");
                for (String element : elements) {
                    deque.add(Integer.parseInt(element.trim()));
                }
            }

            boolean reverse = false;
            boolean error = false;
            for (int j = 0; j < command.length(); j++) {
                if (command.charAt(j) == 'R') {
                    reverse = !reverse;
                } else if(command.charAt(j) == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    else if (!reverse) { //뒤집히지 않았다면
                        deque.removeFirst();
                    } else deque.removeLast();
                }
            }

            if (error) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(reverse ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
        }

    }
}

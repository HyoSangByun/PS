package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Ex_1874 {
static int N;
static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        //초기화
        //맨 처음 숫자까지는 push
        int pushed_number = 0;
        int key = 0;
        for (int i = 1; i <= arr[0]; i++) {
            sb.append('+').append('\n');
            stack.push(i);
            pushed_number = i;
        }

        //처음 나온 숫자까지 무조건 push
        while ( !stack.isEmpty() || pushed_number < N) {
            int toFind = arr[key];
            
            if (!stack.isEmpty() && stack.peek() > toFind) {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == toFind) {
                stack.pop();
                sb.append('-').append('\n');
                key++;
            } else if (pushed_number <= toFind) {
                sb.append('+').append('\n');
                stack.push(++pushed_number);
            } else if (!stack.isEmpty() && toFind > stack.peek()) {
                break;
            }
//            else {
//                System.out.println("NO");
//                return;
//            }
        }

        if (key == N)
            System.out.println(sb.toString());
        else {
            System.out.println("NO");
        }
    }

}

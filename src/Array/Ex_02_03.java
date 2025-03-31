package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_02_03 { //가위바위보
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }

        //1가위 2바위 3보   1>3 2>1 3>1  1<2 2<3 3<1
        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) { //비김
                System.out.println("D");
            } else if ( (A[i]==1 &&B[i]==3) || (A[i]==2 &&B[i]==1) || (A[i]==3 &&B[i]==2)) { // A가 이김
                System.out.println("A");
            } else System.out.println("B");
        }
    }
}

/*


 */

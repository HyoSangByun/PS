package greedy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex_30805_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 입력
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)
            b[i] = Integer.parseInt(st.nextToken());
        // 공통 부분 수열 중 사전 순으로 가장 나중인 수열 구하기
        ArrayList<Integer> num = new ArrayList<>();
        int tmp = 0; int tmp2 = 0;
        while(tmp<=n && tmp2<=m) {
            int max = 0;									// 두 수열에 공통적으로 있는 최댓값
            for(int i=tmp; i<n; i++) {
                for(int j=tmp2; j<m; j++) {
                    if(a[i]==b[j])							// 같은 값 있으면
                        max = Math.max(max, a[i]);			// 비교해서 최댓값 업데이트
                }
            }
            if(max!=0) {
                num.add(max);								// 최댓값 넣고
                while(a[tmp]!=max)							// 인덱스 이동
                    tmp++;
                while(b[tmp2]!=max)							// 인덱스 이동
                    tmp2++;
                tmp++; tmp2++;
            }
            else											// 최댓값 없으면 종료
                break;
        }
        // 출력
        sb.append(num.size()).append("\n");
        for(int i=0; i<num.size(); i++)
            sb.append(num.get(i)).append(" ");
        System.out.print(sb.toString().trim());
    }

}

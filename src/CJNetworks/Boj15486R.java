package CJNetworks;

import java.io.*;
import java.util.*;

public class Boj15486R {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = Integer.parseInt(st.nextToken());
        int[][] arr = new int[day+2][2];
        // i + 1일에 돈 받음
        int[] dp = new int[day+2];

        for(int i=1 ; i<=day ; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[i][0] = count;
            arr[i][1] = cost;
        }

        int max = -1;
        for(int i=1 ; i<=day+1 ; i++) {
            // i일 까지의 수익(dp[i])이 최대일 때 max 값 갱신
            if (dp[i] > max) max = dp[i];
            // 상담 끝나는 날
            int nd = i+arr[i][0];
            if (nd <= day+1) {
                // 상담 끝나는 날짜에 '현재 날짜까지의 최대 금액 + 현재 상담 금액' 과 '현재 날짜에 기록된 금액' 중 더 큰 금액 입력
                dp[nd] = Math.max(dp[nd], max+arr[i][1]);
            }
        }
        System.out.println(max);
    }
}

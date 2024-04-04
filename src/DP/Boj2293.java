package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2293 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K+1];
        int[] coin = new int[N];

        for(int i=0 ; i<N ; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        // 이전에 코인 경우의 수로 구했던거에다가 새로운 코인이 더해진 경우만 더하면됌
        // 10원이 1,2원으로 6가지 에다가 5가 추가되었으니 1,2만으로 5을 구했던거에 5를 추가해서
        // dp[10] = dp[10] + dp[10-5]
        // dp[k] = dp[k] + dp[k-coin[i]]
        dp[0] = 1;
        for(int i=0 ; i<N ; i++) {
            for(int j=coin[i] ; j<=K ; j++) {
                dp[j] += dp[j-coin[i]];
            }
        }

        System.out.println(dp[K]);
    }
}

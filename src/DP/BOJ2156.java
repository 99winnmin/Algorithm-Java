package DP;
import java.util.*;

public class BOJ2156 {
    static int N;
    static int[] value;
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        value = new int[N+1];
        dp = new long[N+1];
        for(int i=1 ; i<=N ; i++) value[i] = sc.nextInt();

        if(N == 1){
            System.out.println(value[1]);
            return;
        }
        if(N == 2){
            System.out.println(value[1]+value[2]);
            return;
        }
        dp[1] = value[1];
        dp[2] = value[1] + value[2];
        for(int i=3 ; i<=N ; i++){
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+value[i-1]+value[i], dp[i-2]+value[i]));
        }

        System.out.println(dp[N]);
    }
}

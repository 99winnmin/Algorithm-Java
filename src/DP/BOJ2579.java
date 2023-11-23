package DP;
import java.io.*;
import java.util.*;

public class BOJ2579 {
    static int N;
    static int[] dp;
    static int[] point;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N+1];
        point = new int[N+1];
        for(int i=1 ; i<=N ; i++) {
            point[i] = sc.nextInt();
        }
        if(N == 1){
            System.out.println(point[1]);
            return;
        }
        if(N == 2){
            System.out.println(point[1]+point[2]);
            return;
        }

        dp[1] = point[1];
        dp[2] = point[1]+point[2];
        // 큰 문제를 작은 문제로,,,
        for(int i=3 ; i<=N ; i++){
            dp[i] = Math.max(dp[i-2]+point[i], dp[i-3]+point[i-1]+point[i]);
        }
        System.out.println(dp[N]);
    }
}

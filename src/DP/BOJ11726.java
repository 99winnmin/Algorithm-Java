package DP;
import java.util.*;
import java.io.*;

public class BOJ11726 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[N+1];

        if(N == 1){
            System.out.println(1);
            return;
        }
        if(N == 2){
            System.out.println(2);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3 ; i<=N ; i++){
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }
        System.out.println(dp[N]);
    }
}

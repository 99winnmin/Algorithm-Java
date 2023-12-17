package DP;
import java.io.*;
import java.util.*;

public class BOJ17626 {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        dp = new int[num+1];
        dp[1] = 1;

        for (int i=2 ; i<=num ; i++){
            Double d = Math.sqrt(i);
            if (d != d.intValue()) {
                int min = Integer.MAX_VALUE;
                for (int j=d.intValue() ; j>=1 ; j--){
                    min = Math.min(min, (dp[(int)Math.pow(j,2)] + dp[i-(int)Math.pow(j,2)]));
                }
                dp[i] = min;
            } else {
                dp[i] = 1;
            }
        }
        System.out.println(dp[num]);
    }
}

package CJNetworks;

import java.io.*;
import java.util.*;

public class Boj2579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] point = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=1 ; i<=n ; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }
        if (n==1 || n==2) {
            if (n==1) System.out.println(point[1]);
            else System.out.println(point[1]+point[2]);
            return;
        }
        dp[1] = point[1];
        dp[2] = point[1] + point[2];
        for(int i=3 ; i<=n ; i++) {
            dp[i] = Math.max(dp[i-2], point[i-1] + dp[i-3]) + point[i];
        }
        System.out.println(dp[n]);
    }
}

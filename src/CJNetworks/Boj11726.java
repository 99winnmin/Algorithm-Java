package CJNetworks;

import java.io.*;
import java.util.*;

public class Boj11726 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        if (n==1) {
            System.out.println(1);
            return;
        }
        if (n==2) {
            System.out.println(2);
            return;
        }
        dp[1]=1; dp[2]=2;
        for(int i=3 ; i<=n ; i++) {
            dp[i] = (dp[i-2] + dp[i-1])%10007;
        }
        System.out.println(dp[n]);
    }
}

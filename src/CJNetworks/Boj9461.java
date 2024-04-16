package CJNetworks;

import java.io.*;
import java.util.*;

public class Boj9461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i=0 ; i<t ; i++) {
            int n = Integer.parseInt(br.readLine());
            list.add(n);
            if (n > max) max = n;
        }
        long[] dp = new long[max+1];
        if(max==1 || max==2 || max==3) {
            list.forEach(i -> System.out.println(1));
            return;
        }

        dp[1]=1; dp[2]=1; dp[3]=1;
        for(int i=4 ; i<=max ; i++) dp[i] = dp[i-2] + dp[i-3];
        list.forEach(i -> System.out.println(dp[i]));
    }
}

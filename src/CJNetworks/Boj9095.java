package CJNetworks;

import java.io.*;
import java.util.*;

public class Boj9095 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();

        for(int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            list.add(n);
            if (n > max) max = n;
        }

        if (max <= 3) {
            list.forEach(i -> {
                if(i == 3) System.out.println(4);
                else if (i==2) System.out.println(2);
                else System.out.println(1);
            });
            return;
        }

        int[] dp = new int[max+1];
        dp[1]=1; dp[2]=2; dp[3]=4;
        for(int i=4 ; i<=max ; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        list.forEach(i -> {
            System.out.println(dp[i]);
        });
    }
}

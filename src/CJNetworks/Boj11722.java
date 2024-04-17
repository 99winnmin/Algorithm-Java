package CJNetworks;

import java.io.*;
import java.util.*;
public class Boj11722 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;

        for(int i=1 ; i<=n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for(int j=i-1 ; j>=1 ; j--) {
                if(arr[j] > arr[i]) dp[i] = Math.max(dp[i],dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }

        if (n != 1) System.out.println(max);
        else System.out.println(1);
    }
}

package CJNetworks;

import java.io.*;

public class Boj1309R {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        for(int i=2 ; i<=n ; i++) {
            // 사자가 n행에 있지 않을 경우에는, 전 행에서 어느 곳에서나 사자가 위치 해도 됨
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901;
            // 사자가 n 행 왼쪽에 있을 경우에는, 전 행에서 사자가 오른 쪽에 있어야 하거나 있지 않아야 함
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901;
            // 사자가 n 행 오른 쪽에 있을 경우에는 , 전 행에서 사자가 왼 쪽에 있어야 하거나 있지 않아야 함
            dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901;
        }
        int answer = 0;
        for(int i=0 ; i<3 ; i++) {
            answer += dp[n][i];
        }
        System.out.println(answer%9901);
    }
}

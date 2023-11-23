package DP;
import java.util.*;
import java.io.*;

public class BOJ1890 {
    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        dp = new long[N+1][N+1];
        dp[1][1] = 1;

        for(int i=1 ; i<=N ; i++){
            String[] nums = br.readLine().split(" ");
            for(int j=1 ; j<=N ; j++){
                map[i][j] = Integer.parseInt(nums[j-1]);
            }
        }

        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                if(map[i][j] == 0) break;
                if(!isOut(map[i][j]+i, j)) dp[map[i][j]+i][j] += dp[i][j];
                if(!isOut(i, map[i][j]+j)) dp[i][map[i][j]+j] += dp[i][j];
            }
        }
        System.out.println(dp[N][N]);
    }

    private static boolean isOut(int x, int y){
        return x>N || y>N;
    }
}

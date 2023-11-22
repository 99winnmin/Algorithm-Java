package DP;
import java.util.*;

public class BOJ2193 {
    static long[] d1, d0;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        d1 = new long[N+1];
        d0 = new long[N+1];
        d0[1] = 0; d1[1] = 1;
        for(int i=2 ; i<=N ; i++){
            d0[i] = (d1[i-1] + d0[i-1]);
            d1[i] = d0[i-1];
        }
        System.out.println((d1[N] + d0[N]));
    }
}

package CJNetworks;

import java.io.*;
import java.util.*;

public class Boj1965R {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        if (total == 1) {
            System.out.println(1);
            return;
        }
        int[] box = new int[total];
        int[] dp = new int[total];
        st = new StringTokenizer(br.readLine());
        int answer = Integer.MIN_VALUE;
        for(int i=0 ; i<total ; i++) {
            box[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            // 해당 박스보다 앞에 있는 것 중에 작은거에 담겨있는거 +1 중에 젤 큰거
            for(int j=0 ; j<i ; j++) {
                if(box[i] > box[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}

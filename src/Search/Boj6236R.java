package Search;

import java.io.*;
import java.util.*;

public class Boj6236R {
    private static int N,M,result;
    private static int[] plan;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        plan = new int[N];
        int max = Integer.MIN_VALUE;
        for(int i=0 ; i<N ; i++) {
            plan[i] = Integer.parseInt(br.readLine());
            if (plan[i] > max) max = plan[i];
        }

        int left = max;
        int right = 10000 * 100000;
        while (left <= right) {
            int withdraw = (left+right)/2;
            int count = simulation(withdraw);
            // 지정한 횟수 이하의 횟수만큼 인출해야 할 경우,
            // 인출 금액이 더 큰 것이므로 더 적은 경우가 있는지 탐색
            if (count <= M) {
                result = withdraw;
                right = withdraw-1;
            }
            // 지정한 횟수보다 더 많이 인출해야 할 경우,
            // 인출 금액이 더 커야한다.
            else { // count > M
                left = withdraw+1;
            }
        }
        System.out.println(result);
    }

    private static int simulation(int withdraw) {
        int count = 1;
        int money = withdraw;
        for (int i : plan) {
            money -= i;
            if (money < 0) {
                count++;
                money = withdraw - i;
            }
        }
        return count;
    }
}

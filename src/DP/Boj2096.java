package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2096 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // max, min 은 각각의 1,2,3번째 줄에서의 기록을 위함
        int[] max = new int[3];
        int[] min = new int[3];

        // 첫번째줄은 그냥 기록
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<3 ; i++) {
            max[i] = Integer.parseInt(st.nextToken());
            min[i] = max[i];
        }

        // 2번째 줄부터 시작
        for (int i=1 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 아래 연산에서 값이 변하므로 미리 기록
            int tmp1 = max[0];
            int tmp2 = max[1];
            int tmp3 = max[2];

            max[0] = Math.max(max[0], max[1]) + a;
            max[1] = Math.max(tmp1, Math.max(max[1], max[2])) + b;
            max[2] = Math.max(tmp2, tmp3) + c;

            tmp1 = min[0];
            tmp2 = min[1];
            tmp3 = min[2];

            min[0] = Math.min(min[0], min[1]) + a;
            min[1] = Math.min(tmp1, Math.min(min[1], min[2])) + b;
            min[2] = Math.min(tmp2, tmp3) + c;
        }
        Arrays.sort(max);
        Arrays.sort(min);
        System.out.println(max[2] + " " + min[0]);
    }
}

package Search;

import java.io.*;
import java.util.*;

public class Boj1654 {
    private static int K,N;
    private static long[] lines;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lines = new long[K];
        for(int i=0 ; i<K ; i++) {
            lines[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(lines);
        long start = 2;
        long end = lines[K-1]+1;
        // Upper bound 이기 때문에 end 값에 +1을 반드시해야함!!!
        // Upper bound 은 찾고자 하는 특정 값을 초과하는 '첫 위치'를 반환한다.
        // +1 을 안할 경우 max 값에 대해서 제대로 체크하지 않음
        while(start < end) {
            long mid = (start+end)/2;
            long make = cut(mid);
            // 만들어진게 적으면 기준 줄길이를 줄려야함
            if (make < N) {
                end = mid;
            } else { // 만들어진게 너무 많으면 줄길이를 늘여야함
                start = mid+1;
            }
        }
        System.out.println(start-1);
    }

    private static long cut(long len) {
        long count = 0;
        for (int i=0 ; i<lines.length ; i++) {
            count += lines[i]/len;
        }
        return count;
    }

}

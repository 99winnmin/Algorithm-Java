package Tree;

import java.io.*;
import java.util.*;

public class Boj2957R {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        /**
         * TreeSet 정리
         * https://velog.io/@db_jam/Java-%ED%8A%B8%EB%A6%AC%EC%85%8BTreeSet-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EC%A0%95%EB%A6%AC
         */
        TreeSet<Integer> tree = new TreeSet<>();
        int N = Integer.parseInt(st.nextToken());

        long count = 0;
        int[] depth = new int[N+2];
        // lower, higher 했을 때 값이 없을 경우 -1 이 탐지되도록함으로써 더 큰 값을 고르도록 유도
        // root 들어갈때도 -1,-1 중에 -1 이 골라져서 0이 들어가도록 설정
        depth[0] = -1;
        depth[N+1] = -1;
        tree.add(0);
        tree.add(N+1);

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            // lower, higher : 가장 가까운 작은, 큰 수 고를 수 있음
            depth[n] = Math.max(depth[tree.lower(n)], depth[tree.higher(n)]) + 1;
            tree.add(n);
            count += depth[n];
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

}

package Search;

import java.io.*;
import java.util.*;

public class Boj1697 {
    static int N,K;
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N,0});
        visited[N] = true;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int n = curr[0];
            visited[n] = true;
            int time = curr[1];
            if (n-1 == K || n+1 == K || n*2 == K) {
                System.out.println(time+1);
                return;
            }
            if (n-1>=0 && !visited[n-1]) queue.add(new int[]{n-1, time+1});
            if (n+1<=100000 && !visited[n+1]) queue.add(new int[]{n+1, time+1});
            if (n*2<=100000 && !visited[n*2]) queue.add(new int[]{n*2, time+1});
        }

    }
}

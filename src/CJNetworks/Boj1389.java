package CJNetworks;

import java.io.*;
import java.util.*;
public class Boj1389 {
    private static int N,M,min = Integer.MAX_VALUE;
    private static int[][] kevin;
    private static boolean[] visited;
    private static List<Integer>[] node;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        node = new ArrayList[N+1];
        kevin = new int[N+1][N+1];

        for(int i=1 ; i<=N ; i++) node[i] = new ArrayList<>();

        for(int i=0 ; i<M ; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            node[first].add(second);
            node[second].add(first);
        }

        for(int i=1 ; i<=N ; i++) {
            visited = new boolean[N+1];
            bfs(i);
        }

        int answer = Integer.MAX_VALUE;
        for(int i=1 ; i<=N ; i++) {
            int sum = 0;
            for(int j=1 ; j<=N ; j++) {
                if (i==j) kevin[i][j] = 0;
                sum += kevin[i][j];
            }
            if (sum < min) {
                min = sum;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start,0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int next : node[curr[0]]) {
                if (!visited[next]) {
                    kevin[start][next] = curr[1]+1;
                    visited[next] = true;
                    queue.offer(new int[]{next, curr[1]+1});
                }
            }
        }
    }
}

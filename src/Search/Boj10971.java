package Search;

import java.io.*;
import java.util.*;

public class Boj10971 {
    private static int minCost = Integer.MAX_VALUE;
    private static int N;
    private static boolean[] visited;
    private static List<int[]>[] node;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        node = new ArrayList[N];

        for (int i=0 ; i<N ; i++) {
            node[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j<N ; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (cost > 0 ) node[i].add(new int[]{j, cost});
            }
        }

        for (int i=0 ; i<N ; i++) {
            visited = new boolean[N];
            DFS(i, i, 1, 0);
        }

        System.out.println(minCost);
    }

    private static void DFS(int start, int curr, int depth, int cost) {
        if (depth == N) {
            boolean isDone = false;
            for (int[] temp : node[curr]) {
                if (temp[0] == start) {
                    cost += temp[1];
                    isDone = true;
                }
            }
            if (isDone && cost < minCost) minCost = cost;
            return;
        }
        visited[curr] = true;
        for (int[] next : node[curr]) {
            int dest = next[0];
            if (!visited[dest]) {
                visited[dest] = true;
                DFS(start, dest, depth+1, cost+next[1]);
                visited[dest] = false;
            }
        }
     }
}

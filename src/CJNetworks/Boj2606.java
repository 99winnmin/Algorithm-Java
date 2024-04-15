package CJNetworks;

import java.io.*;
import java.util.*;

public class Boj2606 {
    private static int N,M;
    private static boolean[] visited;
    private static List<Integer>[] node;
    private static Set<Integer> victim = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        node = new ArrayList[N+1];

        for(int i=1 ; i<=N ; i++) node[i] = new ArrayList<>();

        for(int i=0 ; i<M ; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            node[f].add(s);
            node[s].add(f);
        }

        dfs(1);
        System.out.println(victim.size());
    }

    private static void dfs(int curr) {
        visited[curr] = true;

        for(int next : node[curr]) {
            if (!visited[next]) {
                visited[next] = true;
                victim.add(next);
                dfs(next);
            }
        }
    }
}

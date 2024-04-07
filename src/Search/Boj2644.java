package Search;

import java.io.*;
import java.util.*;

public class Boj2644 {
    private static int N,S,E,M,depth;
    private static List<Integer>[] node;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        node = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i=1 ; i<=N ; i++) node[i] = new ArrayList<>();

        for (int i=0 ; i<M ; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            node[first].add(second);
            node[second].add(first);
        }

        depth = 0;
        dfs(S,0);
        if (depth == 0) System.out.println(-1);
        else System.out.println(depth);
    }

    private static void dfs(int person, int d) {
        if (person == E) {
            depth = d;
        }
        visited[person] = true;

        for (int p : node[person]) {
            if (!visited[p]) {
                visited[p] = true;
                dfs(p, d+1);
            }
        }
    }
}

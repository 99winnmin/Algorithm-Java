package Search;

import java.io.*;
import java.util.*;


public class BOJ11725 {
    static int N;
    static ArrayList<Integer>[] mapper;
    static ArrayList<Integer>[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        mapper = new ArrayList[N+1];
        parents = new ArrayList[N+1];
        for (int i=0 ; i<N+1 ; i++){
            mapper[i] = new ArrayList<>();
            parents[i] = new ArrayList<>();
        }

        visited = new boolean[N+1];
        for(int i=0 ; i<N-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            mapper[u].add(v);
            mapper[v].add(u);
        }

        DFS(1);

        for(int i=2 ; i<=N ; i++){
            System.out.println(parents[i].get(0));
        }

    }

    public static void DFS(int n){
        if (visited[n]) return;
        visited[n] = true;
        for(int k : mapper[n]){
            parents[k].add(n);
            DFS(k);
        }
    }
}

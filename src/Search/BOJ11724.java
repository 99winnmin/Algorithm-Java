package Search;

import java.io.*;
import java.util.*;

public class BOJ11724 {
    static ArrayList<Integer>[] nodeList;
    static boolean visited[];
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 0 ; i<N+1 ; i++){
            nodeList[i] = new ArrayList<Integer>();
        }

        for (int i = 0 ; i<M ; i++ ){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            nodeList[u].add(v);
            nodeList[v].add(u);
        }

        for (int i = 1 ; i<N+1 ; i++ ){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    public static void DFS(int i){
        if(visited[i]) return;
        visited[i] = true;
        for(int k : nodeList[i]){
            if (visited[k] == false) DFS(k);
        }
    }
}

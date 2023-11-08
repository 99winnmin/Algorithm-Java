package Search;

import java.io.*;
import java.util.*;

public class BOJ1260 {
    static ArrayList<Integer>[] nodeList;
    static boolean[] visited;
    static int V;
    static int E;
    static int start;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList[V+1];
        for(int i=1 ; i<V+1 ; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for(int i=0 ; i<E ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            nodeList[u].add(v);
            nodeList[v].add(u);
        }

        for(int i=1 ; i<V+1 ; i++) {
            Collections.sort(nodeList[i]);
        }

        // DFS
        visited = new boolean[V+1];
        DFS(start);

        System.out.println();
        // BFS
        visited = new boolean[V+1];
        BFS(start);
    }

    public static void DFS(int num) {
        if(visited[num]) return;
        System.out.print(num + " ");
        visited[num] = true;
        for(int k : nodeList[num]){
            DFS(k);
        }
    }

    public static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(num);
        visited[num] = true;

        while(!queue.isEmpty()){
            int currNum = queue.poll();
            System.out.print(currNum + " ");
            for(int k : nodeList[currNum]){
                if (!visited[k]) {
                    visited[k] = true;
                    queue.add(k);
                }
            }
        }
    }
}

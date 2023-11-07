package Search;

import java.util.*;
import java.io.*;


public class BOJ13023 {
    static ArrayList<Integer>[] nodeList;
    static boolean arrive = false;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList[N];
        visited = new boolean[N];
        for (int i=0 ; i<N ; i++ ){
            nodeList[i] = new ArrayList<>();
        }

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            nodeList[u].add(v);
            nodeList[v].add(u);
        }

        for (int i=0 ; i<N ; i++){
            DFS(i, 1);
            if (arrive) break;
        }

        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static void DFS(int person, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[person] = true;
        for (int i : nodeList[person]){
            if (!visited[i]) DFS(i, depth+1);
        }
        visited[person] = false; // depth 를 5찍지 못했을 경우 다시 봐봐야하기 때문에 false 로 변환
    }
}

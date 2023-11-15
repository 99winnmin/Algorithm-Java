package Graph;

import java.io.*;
import java.util.*;

public class BOJ1325 {
    static ArrayList<Integer>[] node;
    static int N,M;
    static int[] answer;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        answer = new int[N+1];
        node = new ArrayList[N+1];
        for(int i=1 ; i<=N ; i++) node[i] = new ArrayList<>();
        for(int i=0 ; i<M ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            node[u].add(v);
        }
        // 신뢰도가 제일 높은 컴퓨터들이 제일 위험함
        for(int i=1 ; i<=N ; i++) {
            visited = new boolean[N+1];
            BFS(i);
        }

        int max = -1;
        for(int i=1 ; i<=N ; i++){
            if (answer[i] > max) max = answer[i];
        }

        for(int i=1 ; i<=N ; i++){
            if (answer[i] == max) System.out.print(i + " ");
        }
    }

    static void BFS(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int k : node[curr]){
                if(!visited[k]) {
                    visited[k] = true;
                    answer[k]++;
                    q.add(k);
                }
            }
        }
    }
}

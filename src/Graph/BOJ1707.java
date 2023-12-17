package Graph;
import java.io.*;
import java.util.*;

public class BOJ1707 {
    static int K,V,E;
    static int[] memo;
    static String[] answer;
    static ArrayList<Integer>[] node;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        answer = new String[K];
        for(int i=0 ; i<K ; i++) answer[i] = "YES";

        for(int i=0 ; i<K ; i++){
            V = sc.nextInt();
            E = sc.nextInt();
            node = new ArrayList[V+1];
            visited = new boolean[V+1];
            memo = new int[V+1];
            for(int j=1 ; j<=V ; j++) node[j] = new ArrayList<>();

            for(int j=0 ; j<E ; j++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                node[u].add(v);
                node[v].add(u);
            }
            for(int j=1 ; j<=V ; j++){
                if(answer[i].equals("NO")) break;
                DFS(j, i);
            }
        }

        for(String s : answer) System.out.println(s);
    }

    static void DFS(int n, int testCase){
        visited[n] = true;

        for(int curr : node[n]){
            if(!visited[curr]){
                memo[curr] = (memo[n]+1)%2;
                DFS(curr, testCase);
            } else if(memo[curr] == memo[n]) {
                answer[testCase] = "NO";
            }
        }
    }
}

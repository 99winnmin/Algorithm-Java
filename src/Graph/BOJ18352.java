package Graph;
import java.io.*;
import java.util.*;

public class BOJ18352 {
    static int N,M,K,X; // 도시 개수, 도로 개수, 거리 정보, 출발 도시 번호
    static ArrayList<Integer>[] nodes;
    static int[] visited;
    static List<Integer> total = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();

        nodes = new ArrayList[N+1];

        for(int i=1 ; i<=N ; i++) nodes[i] = new ArrayList<>();

        for(int i=0 ; i<M ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            nodes[u].add(v);
        }

        visited = new int[N+1];
        Arrays.fill(visited, -1);

        BFS(X);

        for(int i=1 ; i<=N ; i++){
            if (visited[i] == K) total.add(i);
        }

        if (total.size() == 0) {
            System.out.println("-1");
        } else {
            total.forEach(System.out::println);
        }

    }

    static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        visited[node]++;
        queue.add(node);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for (int k : nodes[curr]) {
                if(visited[k] == -1) {
                    visited[k] = visited[curr] + 1;
                    queue.add(k);
                }
            }
        }
    }
}

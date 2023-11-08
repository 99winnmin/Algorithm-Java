package Search;

import java.io.*;
import java.util.*;

public class BOJ1167 {
    static int V;
    static boolean[] visited;
    static List<Edge>[] nodeList;
    static int[] distanceList;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        nodeList = new ArrayList[V+1];

        for (int i=1 ; i<=V ; i++){
            nodeList[i] = new ArrayList<Edge>();
        }

        for(int i=1 ; i<V+1 ; i++){
            int num = sc.nextInt();
            while(true) {
                int e = sc.nextInt();
                if (e < 0) break;
                int distance = sc.nextInt();
                nodeList[num].add(new Edge(e, distance));
            }
        }

        // 임의의 노드에서 가장 먼 곳은 트리의 지름의 두 노드 중 하나이다.
        visited = new boolean[V+1];
        distanceList = new int[V+1];
        BFS(2);

        int max = 1;
        for (int i=1 ; i<V+1 ; i++){
            if(distanceList[i] > distanceList[max]) max = i;
        }

        visited = new boolean[V+1];
        distanceList = new int[V+1];
        BFS(max);

        int result = 0;
        for (int i=1 ; i<V+1 ; i++){
            if(distanceList[i] > result) result = distanceList[i];
        }

        System.out.println(result);
    }

    static class Edge {
        int e;
        int distance;

        public Edge(int e, int distance) {
            this.e = e;
            this.distance = distance;
        }
    }

    public static void BFS(int startNum) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNum);
        visited[startNum] = true;

        while(!queue.isEmpty()){
            int currNum = queue.poll();
            for(Edge edge : nodeList[currNum]){
                if(!visited[edge.e]) {
                    visited[edge.e] = true;
                    distanceList[edge.e] = distanceList[currNum] + edge.distance;
                    queue.add(edge.e);
                }
            }
        }
    }
}

package Graph;
import java.io.*;
import java.util.*;

// 다익스트라
public class BOJ1753 {
    static int V,E,start;
    static Integer[] d;
    static boolean[] visited;
    static ArrayList<Edge>[] node;
    static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    public static void main(String[] args) throws Exception {
        init();
        solution();
        print();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        d = new Integer[V+1];
        visited = new boolean[V+1];
        node = new ArrayList[V+1];
        for(int i=1 ; i<=V ; i++) node[i] = new ArrayList<Edge>();
        for(int i=0 ; i<=V ; i++) d[i] = Integer.MAX_VALUE;

        for(int i=0 ; i<E ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            node[u].add(new Edge(v, w));
        }

    }
    private static void print(){
        for(int i=1 ; i<=V ; i++){
            if (visited[i]) {
                System.out.println(d[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
    private static void solution(){
        // 시작점 설정하기
        pq.add(new Edge(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            int currVertex = curr.vertex;
            if(visited[currVertex]) continue;
            visited[currVertex] = true;

            for(int i=0 ; i<node[currVertex].size() ; i++){
                Edge temp = node[currVertex].get(i);
                int next = temp.vertex;
                int value = temp.value;
                if(d[next] > d[currVertex] + value) {
                    d[next] = value + d[currVertex];
                    pq.add(new Edge(next, d[next]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int value;
        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge e){
            if (this.value > e.value) return 1;
            else return -1;
        }
    }
}

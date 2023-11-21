package Graph;
import java.io.*;
import java.util.*;

public class BOJ1916 {
    static int city, bus, start, end;
    static Integer[] distance;
    static boolean[] visited;
    static ArrayList<Bus>[] node;
    static PriorityQueue<Bus> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        init();
        solution();
        print();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        city = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        bus = Integer.parseInt(st.nextToken());
        distance = new Integer[city+1];
        visited = new boolean[city+1];
        node = new ArrayList[city+1];

        for(int i=1 ; i<=city ; i++) {
            node[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        for(int i=0 ; i<bus ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            node[u].add(new Bus(v,w));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    private static void print(){
        System.out.println(distance[end]);
    }

    private static void solution(){
        distance[start] = 0;
        pq.add(new Bus(start, 0));
        while(!pq.isEmpty()){
            Bus bus = pq.poll();
            int curr = bus.next;
            if (visited[bus.next]) continue;
            visited[bus.next] = true;

            for(int i=0 ; i<node[curr].size() ; i++){
                Bus temp = node[curr].get(i);
                int next = temp.next;
                int time = temp.time;
                // 현재보다 시간이 작은 곳은 가볼만한 가치가 있기에 PQ에 추가
                if (distance[next] > time + distance[curr]){
                    distance[next] = time + distance[curr];
                    pq.add(new Bus(next, distance[next]));
                }
            }
        }
    }

    static class Bus implements Comparable<Bus> {
        int next;
        int time;
        public Bus(int next, int time){
            this.next = next;
            this.time = time;
        }
        @Override
        public int compareTo(Bus other){ // 시간 오름 차순
            return this.time - other.time;
        }
    }
}

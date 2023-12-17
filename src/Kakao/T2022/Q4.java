package Kakao.T2022;

import java.io.*;
import java.util.*;

public class Q4 {

    public static void main(String[] args) {

    }
    static int[] intensity, gateList, summitList;
    static boolean[] visited;
    static ArrayList<Node>[] nodes;
    static PriorityQueue<Node> pq;
    static ArrayList<int[]> answer = new ArrayList<>();
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        gateList = gates;
        summitList = summits;
        intensity = new int[n+1];
        nodes = new ArrayList[n+1];
        for(int i=0 ; i<summits.length ; i++) intensity[summits[i]] = Integer.MIN_VALUE;
        for(int i=0 ; i<summits.length ; i++) nodes[i] = new ArrayList<>();

        for(int i=0 ; i<paths.length ; i++){
            int[] path = paths[i];
            nodes[path[0]].add(new Node(path[1], path[2]));
            nodes[path[1]].add(new Node(path[0], path[2]));
        }

        for(int i=0 ; i<gates.length ; i++){
            pq = new PriorityQueue<>();
            visited = new boolean[n+1];
            pq.add(new Node(gates[i], 0));
            while(!pq.isEmpty()){

            }
            for(int j=0 ; j<summits.length ; j++) answer.add(new int[]{gates[i], intensity[summits[j]]});
        }

        answer.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });
        return answer.get(0);
    }

    private static boolean isGate(int curr){
        for(int i=0 ; i<gateList.length ; i++){
            if (gateList[i] == curr) return true;
        }
        return false;
    }

    private static boolean isSummit(int curr) {
        for(int i=0 ; i<summitList.length ; i++){
            if (summitList[i] == curr) return true;
        }
        return false;
    }

    static class Node implements Comparable<Node> {
        int v; int time;
        public Node(int v, int time){
            this.v = v;
            this.time = time;
        }
        @Override
        public int compareTo(Node o){
            return this.time - o.time;
        }
    }
}

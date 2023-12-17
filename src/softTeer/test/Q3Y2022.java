package softTeer.test;

import java.io.*;
import java.util.*;

public class Q3Y2022 {
    static int size, jump;
    static ArrayList<Integer>[] node;
    static boolean[] visited;
    static int curr = 0;
    static int move = 0;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        size = Integer.parseInt(line1[0]);
        jump = Integer.parseInt(line1[1]);
        node = new ArrayList[size];
        visited = new boolean[size];
        for(int i=0 ; i<size ; i++) node[i] = new ArrayList<>();

        for(int i=0 ; i<jump ; i++){
            String[] line2 = br.readLine().split(" ");
            int u = Integer.parseInt(line2[0]);
            int v = Integer.parseInt(line2[1]);
            node[u].add(v);
        }

        while(curr < size - 1) {
            move = 0;
            for(int i=1 ; i<=6 ; i++){
                if(node[curr+i].size() == 1){
                    DFS(curr);
                }
            }
            answer++;
            curr = Math.max(curr+6, move);
        }

        System.out.println(answer);

    }

    private static void DFS(int curr){
        int next = node[curr].get(0);
        if(next > curr) {
            move = Math.max(next, move);
        }
    }
}

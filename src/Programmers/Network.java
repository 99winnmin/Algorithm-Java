package Programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Network {

    public static void main(String[] args) {
        Solution s = new Solution();
    }

    static class Solution {
        static boolean[] visited;
        static ArrayList<Integer>[] node;
        public int solution(int n, int[][] computers) {
            node = new ArrayList[computers.length];
            visited = new boolean[computers.length];
            for(int i=0 ; i<computers.length ; i++){
                node[i] = new ArrayList<>();
                for(int j=0 ; j<computers.length ; j++){
                    if (i==j) continue;
                    if(computers[i][j] == 1) node[i].add(j);
                }
            }

            int answer = 0;
            for(int i=0 ; i<computers.length ; i++){
                if(!visited[i]){
                    DFS(i);
                    answer++;
                }
            }

            return answer;
        }

        public void DFS(int computer){
            if(visited[computer]){
                return;
            }
            visited[computer] = true;

            for(int com : node[computer]){
                if (!visited[com]) DFS(com);
            }
        }
    }
}

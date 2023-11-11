package Programmers;

import java.util.*;

public class TravelLoad {

    public static void main(String[] args) {
        // DFS? BFS? 완전 탐색이므로 DFS
        // 사전 순 앞서는게 숫자가 더 작음
        Solution2 s = new Solution2();
        String[][] list = new String[][]{{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}};
//        String[][] list = new String[][]{{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
        String[] solution = s.solution(list);
        for(String ss : solution){
            System.out.print(ss + " ");
        }
    }
}

class Solution2 {
    static boolean[] visited;
    static ArrayList<String> pList = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        DFS(0, "ICN","ICN", tickets);
        Collections.sort(pList);
        return pList.get(0).split(" ");
    }

    static void DFS(int count, String start, String path, String[][] tickets) {
        if (count == tickets.length){
            pList.add(path);
            return;
        }

        for(int i=0 ; i<tickets.length ; i++){
            if(!visited[i] && start.equals(tickets[i][0])){
                visited[i] = true;
                DFS(count+1, tickets[i][1], path+" "+tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}
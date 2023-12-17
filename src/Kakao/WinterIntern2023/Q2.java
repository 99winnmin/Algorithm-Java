package Kakao.WinterIntern2023;
import java.io.*;
import java.util.*;
public class Q2 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2,3}, {4,3}, {1,1}, {2,1}}));
    }

    static ArrayList<Integer>[] node = new ArrayList[1_000_001];
//    static boolean[] visited = new boolean[1_000_001];
    static int start, caseStartNum;
//    static boolean isShape8;
    static int[] answer = new int[4];

    public static int[] solution(int[][] edges) {
        start = edges[0][0];
        for(int i=0 ; i<edges.length ; i++){
            if (node[edges[i][0]] == null) node[edges[i][0]] = new ArrayList<>();
            node[edges[i][0]].add(edges[i][1]);
        }

        for(int i=0 ; i<node[start].size() ; i++){
            caseStartNum = node[start].get(i);
//            visited = new boolean[1_000_001];
//            isShape8 = false;
            DFS(caseStartNum);
        }
        return answer;
    }

    private static void DFS(int x){
        System.out.println(x);
        // 도넛 모양인지 체크
//        if (x == caseStartNum && (node[x].isEmpty() || node[x] == null)){
//            answer[1]++;
//            return;
//        }
        // 막대 모양인지 체크
        if (node[x].isEmpty()){
            answer[2]++;
            return;
        }
        // 8자 모양인지 체크
        if (x == caseStartNum && !node[x].isEmpty()){
            answer[3]++;
            return;
        }

        for(int d=0 ; d<node[x].size() ; d++){
            DFS(node[x].remove(d));
        }

    }
}

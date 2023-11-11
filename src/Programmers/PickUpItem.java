package Programmers;

import java.util.*;
public class PickUpItem {

    public static void main(String[] args) {
        // DFS? BFS? 최단 경로와 깊이가 있기 때문에 BFS 로 채택
        // 간격이 1일 때를 대비하기 위해서 *2 하는 아이디어로 문제 풀기
        Solution s = new Solution();
        s.solution(new int[][]{{1, 1, 7, 4},{3, 2, 5, 5},{4, 3, 6, 9},{2, 6, 8, 8}}, 1,3,7,8);
        s.solution(new int[][]{{1, 1, 8, 4},{2, 2, 4, 9},{3, 6, 9, 8},{6, 3, 7, 7}}, 9,7,6,1);
    }
}

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] nodes;
    static int[][] rectCopy;
    static boolean[][] visited;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        rectCopy = new int[rectangle.length][4];
        nodes = new int[102][102];
        visited = new boolean[102][102];

        for(int i=0 ; i<rectangle.length ; i++){
            rectCopy[i] = new int[]{rectangle[i][0]*2, rectangle[i][1]*2, rectangle[i][2]*2, rectangle[i][3]*2};
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];
            for(int j=x1*2; j<=x2*2 ; j++){
                if (j==x1*2 || j==x2*2) {
                    for(int k=y1*2; k<=y2*2 ; k++){
                        nodes[j][k] = 1;
                    }
                } else {
                    nodes[j][y1*2] = 1;
                    nodes[j][y2*2] = 1;
                }
            }
        }

        if(characterX>=1 && characterY>=1)
            BFS(characterX*2, characterY*2);
        if(nodes[itemX*2][itemY*2] != 1)
            answer = nodes[itemX*2][itemY*2] / 2;

        return answer;
    }

    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] currNode = queue.poll();

            for(int i=0 ; i<4 ; i++){
                int nextX = dx[i] + currNode[0];
                int nextY = dy[i] + currNode[1];
                if(!isOut(nextX, nextY) && !isInBlock(nextX, nextY) && !visited[nextX][nextY] && nodes[nextX][nextY] == 1){
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                    nodes[nextX][nextY] = nodes[currNode[0]][currNode[1]] + 1;
                }
            }
        }
    }

    static boolean isOut(int x, int y){
        if (x<0 || y<0 || x>=102 || y>=102) return true;
        return nodes[x][y] == 0;
    }

    static boolean isInBlock(int x, int y){
        for(int q=0 ; q<rectCopy.length ; q++){
            int x1 = rectCopy[q][0];
            int y1 = rectCopy[q][1];
            int x2 = rectCopy[q][2];
            int y2 = rectCopy[q][3];
            if (x > x1 && x < x2 && y > y1 && y < y2) return true;
        }
        return false;
    }
}
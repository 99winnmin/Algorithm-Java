package Search;

import java.io.*;
import java.util.*;

public class BOJ2178 {
    static int N;
    static int M;
    static int result = 0;
    static int[][] miro;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0 ; j<M ; j++){
                miro[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }

        BFS(0,0);
        System.out.println(miro[N-1][M-1]);

    }

    public static void BFS(int startX, int startY) {
        result++;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            int[] currNode = queue.poll();
            if (currNode[0] == N-1 && currNode[1] == M-1) break;
            for(int i=0 ; i<4 ; i++){
                int nextX = dx[i]+currNode[0];
                int nextY = dy[i]+currNode[1];
                if (!isOut(nextX, nextY) && miro[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    miro[nextX][nextY] = miro[currNode[0]][currNode[1]] + 1;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }
    }

    public static boolean isOut(int x, int y){
        return x<0 || y<0 || x>=N || y>=M;
    }
}

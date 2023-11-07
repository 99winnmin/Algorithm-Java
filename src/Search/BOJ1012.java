package Search;

import java.io.*;
import java.util.*;

public class BOJ1012 {
    static boolean[][] farm;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int T;
    static int M;
    static int N;
    static int cabbage;
    static int bug;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i=0 ; i<T ; i++){
            bug = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            visited = new boolean[M][N]; // 방문 안한 곳은 false
            farm = new boolean[M][N];

            cabbage = Integer.parseInt(st.nextToken());

            for(int j=0 ; j<cabbage ; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[x][y] = true;
            }

            for (int j=0 ; j<M ; j++){
                for (int k=0 ; k<N ; k++){
                    if (farm[j][k] && !visited[j][k]) {
                        DFS(j,k);
                        bug++;
                    }
                }
            }
            System.out.println(bug);
        }
    }

    public static void DFS(int x, int y){
        if (visited[x][y]) return;
        visited[x][y] = true;

        for (int i=0 ; i<4 ; i++){
            int nextX = dx[i]+x;
            int nextY = dy[i]+y;
            if (!isOut(nextX, nextY) && farm[nextX][nextY]) DFS(nextX, nextY);
        }
    }

    public static boolean isOut(int u, int v) {
        return u < 0 || v < 0 || u >= M || v >= N;
    }

}

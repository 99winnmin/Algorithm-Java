package Search;

import java.io.*;
import java.util.*;

public class Boj1987 {
    private static int R,C;
    private static boolean[][] visited;
    private static char[][] history;
    private static int[] alpa = new int[26];
    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,-1,0,1};
    private static int max = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[R][C];
        history = new char[R][C];

        for (int i=0 ; i<R ; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j=0 ; j<C ; j++) {
                history[i][j] = line[j];
            }
        }

        visited[0][0] = true;
        alpa[history[0][0]-65]++;
        dfs(0,0,1);

        System.out.println(max);

    }

    private static void dfs(int x, int y, int depth) {
        if (depth > max) max = depth;
        if (alpa[history[x][y]-65] > 1) {
            return;
        }

        for (int i=0 ; i<4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!isOut(nx, ny) && alpa[history[nx][ny]-65] <= 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                alpa[history[nx][ny]-65]++;
                dfs(nx, ny, depth+1);
                alpa[history[nx][ny]-65]--;
                visited[nx][ny] = false;
            }
        }
    }

    private static boolean isOut(int x, int y) {
        return x<0 || y<0 || x>=R || y>=C;
    }
}

package Search;

import java.io.*;
import java.util.*;

public class Boj2583 {
    private static int N,M,C;
    private static boolean[][] visited;
    private static int[][] map;
    private static int size;
    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,-1,0,1};
    private static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[M+1][N+1];
        map = new int[M+1][N+1];

        for (int i=0 ; i<C ; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j=x1 ; j<x2 ; j++) {
                for (int k=y1 ; k<y2 ; k++) {
                    map[j][k]--;
                }
            }
        }

        for (int j=0 ; j<M ; j++) {
            for (int k=0 ; k<N ; k++) {
                if (map[j][k] == 0) {
                    size = 1;
                    map[j][k] = size;
                    dfs(j,k);
                    answer.add(size);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        answer.forEach(i -> System.out.print(i + " "));
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i=0 ; i<4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!isOut(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {
                if (map[nx][ny] == 0) {
                    size++;
                    map[nx][ny] = size;
                }
                visited[nx][ny] = true;
                dfs(nx,ny);
                visited[nx][ny] = false;
            }
        }
    }

    private static boolean isOut(int x, int y) {
        return x<0 || y<0 || x>=M || y>=N;
    }
}

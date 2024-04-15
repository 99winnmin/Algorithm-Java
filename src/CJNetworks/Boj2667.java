package CJNetworks;

import java.io.*;
import java.util.*;

public class Boj2667 {
    private static int N;
    private static boolean[][] visited;
    private static int[][] town;
    private static List<Integer> answer = new ArrayList<>();
    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];
        town = new int[N][N];

        for(int i=0 ; i<N ; i++) {
            String[] input = br.readLine().split("");
            for(int j=0 ; j<N ; j++) {
                town[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i=0 ; i<N ; i++) {
            for(int j=0 ; j<N ; j++) {
                if(town[i][j] == 1) answer.add(dfs(i,j,1));
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        answer.forEach(System.out::println);
    }

    private static int dfs(int x, int y, int depth) {
        visited[x][y] = true;

        for (int k=0 ; k<4 ; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (!isOut(nx, ny) && !visited[nx][ny] && town[nx][ny] == 1) {
                town[nx][ny] = 0;
                visited[nx][ny] = true;
                depth = dfs(nx, ny, depth + 1);
            }
        }
        return depth;
    }

    private static boolean isOut(int x, int y) {
        return x<0 || y<0 || x>=N || y>=N;
    }
}

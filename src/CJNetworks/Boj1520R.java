package CJNetworks;

import java.io.*;
import java.util.*;

public class Boj1520R {
    private static int m,n;
    private static int[][] map, dp;
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        dp = new int[m][n];
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        bfs();
        System.out.println(dp[m-1][n-1]);
    }

    private static void bfs() {
        // 겹치게 지나가는 곳까지 기다리는 것이 핵심
        // 32,20 / 32,30,25,20 : 2가지 경로 모두 20에 도달할때까지 20 다음으로 넘어가지 않음
        PriorityQueue<Pos> queue = new PriorityQueue<>();
        queue.add(new Pos(0,0,map[0][0]));

        while(!queue.isEmpty()) {
            Pos curr = queue.poll();

            for(int i=0 ; i<4 ; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (!isOut(nx, ny) && map[nx][ny] < curr.h) {
                    // 큐 에 들어간적 없다 조사 대상
                    if (dp[nx][ny] == 0) queue.add(new Pos(nx,ny,map[nx][ny]));
                    // 큐 에 들어간적이 있다면 지금까지 쌓아온 값을 더함
                    dp[nx][ny] += dp[curr.x][curr.y];
                }
            }
        }
    }

    private static boolean isOut(int x, int y) {
        return x<0 || y<0 || x>=m || y>=n;
    }

    private static class Pos implements Comparable<Pos> {
        int x,y,h;
        public Pos(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }

        @Override
        public int compareTo(Pos o) {
            // 내림차순
            return o.h - this.h;
        }
    }
}

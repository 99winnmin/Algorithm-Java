package CJNetworks;

import java.io.*;
import java.util.*;

public class Boj1600R {
    private static int K,W,H,answer = Integer.MAX_VALUE;
    private static int[][][] visited;
    private static int[][] board;
    private static int[] horseX = {-2,-1,1,2,2,1,-1,-2};
    private static int[] horseY = {1,2,2,1,-1,-2,-2,-1};
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,-1,0,1};

    private static class Node {
        int x,y,count,remain;
        public Node(int x, int y, int count, int remain) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.remain = remain;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visited = new int[H][W][K+1];
        board = new int[H][W];

        for(int i=0 ; i<H ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<W ; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) board[i][j] = -1;
            }
        }

        jump(0,0);

        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    private static void jump(int startX, int startY) {
        Queue<Node> queue = new LinkedList<>();
        visited[startX][startY][K] = 1;
        queue.add(new Node(startX, startY, 0, K));

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.x == H-1 && curr.y == W-1) answer = Math.min(answer, curr.count);
            visited[curr.x][curr.y][curr.remain] = 1;

            for(int i=0 ; i<4 ; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (!isOut(nx, ny) && board[nx][ny] != -1 && visited[nx][ny][curr.remain] != 1) {
                    queue.add(new Node(nx, ny, curr.count+1, curr.remain));
                    visited[nx][ny][curr.remain] = 1;
                }
            }

            if (curr.remain > 0) {
                for(int i=0 ; i<8 ; i++) {
                    int nx = curr.x + horseX[i];
                    int ny = curr.y + horseY[i];
                    if (!isOut(nx, ny) && board[nx][ny] != -1 && visited[nx][ny][curr.remain-1] != 1) {
                        queue.add(new Node(nx,ny,curr.count+1,curr.remain-1));
                        visited[nx][ny][curr.remain-1] = 1;
                    }
                }
            }
        }
    }

    private static boolean isOut(int x, int y) {
        return x<0 || y<0 || x>=H || y>=W;
    }
}

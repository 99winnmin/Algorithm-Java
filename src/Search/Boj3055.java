package Search;

import java.io.*;
import java.util.*;

public class Boj3055 {
    private static int R,C;
    private static int[][] forest = new int[50][50];
    private static List<int[]> waters = new ArrayList<>();
    private static int[][] load = new int[50][50];
    private static boolean[][] visited = new boolean[50][50];
    private static int[] D,S;
    private static final  int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i=0 ; i<R ; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j=0 ; j<C ; j++) {
                char word = line[j];
                if (word == 'D') {
                    D = new int[]{i,j};
                    forest[i][j] = 200;
                } else if (word == 'S') {
                    S = new int[]{i,j};
                    load[i][j] = 1;
                } else if (word == '*') {
                    forest[i][j] = 1;
                    waters.add(new int[]{i,j});
                } else if (word == 'X') {
                    forest[i][j] = -1;
                    load[i][j] = -1;
                }
            }
        }

        fill();
        visited = new boolean[50][50];
        move(S[0], S[1]);

        if (load[D[0]][D[1]] == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(load[D[0]][D[1]]-1);
        }
    }

    private static void fill() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0 ; i<waters.size() ; i++) {
            int[] point = waters.get(i);
            queue.add(new int[]{point[0], point[1]});
            visited[point[0]][point[1]] = true;
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int k=0 ; k<4 ; k++) {
                int nextX = dx[k] + curr[0];
                int nextY = dy[k] + curr[1];
                if (!isOut(nextX,nextY) && !visited[nextX][nextY] && forest[nextX][nextY] == 0) {
                    forest[nextX][nextY] = forest[curr[0]][curr[1]]+1;
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    private static void move(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int k=0 ; k<4 ; k++) {
                int nextX = dx[k] + curr[0];
                int nextY = dy[k] + curr[1];
                if (!isOut(nextX,nextY) && !visited[nextX][nextY] && (forest[nextX][nextY] == 0 || load[curr[0]][curr[1]]+1 < forest[nextX][nextY])) {
                    load[nextX][nextY] = load[curr[0]][curr[1]]+1;
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    private static boolean isOut(int x, int y) {
        return x<0 || y<0 || x>=R || y>=C;
    }
}

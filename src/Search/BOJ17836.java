package Search;
import java.io.*;
import java.util.*;
public class BOJ17836 {
    static int N,M,T,noSwordTime,swordTime,answer;
    static int[] sword;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws Exception {
        init();
        solution();
        print();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);
        T = Integer.parseInt(firstLine[2]);
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0 ; i<N ; i++){
            String[] line = br.readLine().split(" ");
            for (int j=0 ; j<M ; j++){
                int spot = Integer.parseInt(line[j]);
                map[i][j] = spot;
                if (spot == 2) {
                    sword = new int[]{i,j};
                }
            }
        }
    }

    private static void print() {
        if (answer <= T && answer > 0) {
            System.out.println(answer);
        } else {
            System.out.println("Fail");
        }
    }

    private static void solution() {
        BFS(0,0);
        if (swordTime != 0 && noSwordTime != 0) {
            answer = Math.min(swordTime, noSwordTime);
        } else {
            answer = Math.max(swordTime, noSwordTime);
        }
    }

    private static void BFS(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] currNode = queue.poll();
            if (currNode[0] == N-1 && currNode[1] == M-1) {
                noSwordTime = map[currNode[0]][currNode[1]];
            }

            for (int i=0 ; i<4 ; i++) {
                int nextX = dx[i] + currNode[0];
                int nextY = dy[i] + currNode[1];
                if (!isOut(nextX, nextY) && (map[nextX][nextY] == 0 || map[nextX][nextY] == 2) && !visited[nextX][nextY]) {
                    if (nextX == sword[0] && nextY == sword[1]) {
                        swordTime = map[currNode[0]][currNode[1]] + (N-1-sword[0]) + (M-1-sword[1]) + 1;
                    }
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = map[currNode[0]][currNode[1]] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    private static boolean isOut(int x, int y){
        return x<0 || y<0 || x>=N || y>=M;
    }
}

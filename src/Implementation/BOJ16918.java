package Implementation;
import java.io.*;
import java.util.*;

public class BOJ16918 {
    static int R,C,N;
    static Grid[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new Grid[R][C];

        for (int i=0 ; i<R ; i++){
            String[] token = br.readLine().split("");
            for (int j=0 ; j<C ; j++){
                map[i][j] = new Grid(token[j], 0);
            }
        }

        for (int i=1 ; i<=N ; i++) {
            if (i == 1) {
                for (int j=0 ; j<R ; j++) {
                    for (int k=0 ; k<C ; k++) {
                        map[j][k].plusTime();
                    }
                }
                continue;
            }

            for (int j=0 ; j<R ; j++) {
                for (int k=0 ; k<C ; k++) {
                    if (i%2 == 0) { // 폭탄 심기
                        map[j][k].makeBomb();
                    } else { // 폭탄 터트리기
                        if (map[j][k].bombOrPass()) { // 상하좌우 터트리기
                            for (int q=0 ; q<4 ; q++){
                                int nextX = j+dx[q];
                                int nextY = k+dy[q];
                                if(!isOut(nextX, nextY)) map[nextX][nextY].bomb();
                            }
                        } else {
                            map[j][k].plusTime();
                        }
                    }
                }
            }
        }

        for (int i=0 ; i<R ; i++){
            for (int j=0 ; j<C ; j++){
                System.out.print(map[i][j].status);
            }
            System.out.println();
        }
    }

    private static boolean isOut(int x, int y) {
        return x<0 || y<0 || x>=R || y>=C;
    }

    static class Grid {
        String status;
        int time;
        public Grid(String status, int time) {
            this.status = status;
            this.time = time;
        }

        public void bomb() {
            if (this.time == 2) return;
            this.status = ".";
            this.time = 0;
        }

        public boolean bombOrPass() {
            if (this.time == 2) {
                this.status = ".";
                this.time = 0;
                return true;
            }
            return false;
        }

        public void makeBomb() {
            if (this.status.equals(".")) {
                this.status = "O"; this.time = 0;
            } else {
                this.time++;
            }
        }

        public void plusTime() {
            if(status.equals("O")) this.time++;
        }
    }
}

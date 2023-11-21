package Implementation;

import java.io.*;
import java.util.*;

public class BOJ2578 {
    static int answer = 0;
    static boolean isEnd = false;
    static int[][] map = new int[5][5];
    static int[][] check = new int[5][5];
    static int[][] call = new int[5][5];
    public static void main(String[] args) throws Exception {
        init();
        solution();
        print();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0 ; i<5 ; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0 ; j<5 ; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int i=0 ; i<5 ; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0 ; j<5 ; j++){
                call[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    private static void print(){
        System.out.println(answer);
    }

    private static void solution() {
        for(int i=0 ; i<5 ; i++){
            for(int j=0 ; j<5 ; j++){
                callNum(call[i][j]);
                answer++;
                check();
                if(isEnd) return;
            }
        }
    }

    private static void callNum(int num) {
        for(int i=0 ; i<5 ; i++){
            for(int j=0 ; j<5 ; j++){
                if(map[i][j] == num) check[i][j] = 1;
            }
        }
    }

    private static void check() {
        int bingoCount = 0;
        // 세로 체크
        for(int u=0 ; u<5 ; u++){
            int lineCheck = 1;
            for(int v=0 ; v<5 ; v++){
                lineCheck *= check[v][u];
            }
            if (lineCheck == 1) bingoCount++;
        }
        // 가로 체크
        for(int u=0 ; u<5 ; u++){
            int lineCheck = 1;
            for(int v=0 ; v<5 ; v++){
                lineCheck *= check[u][v];
            }
            if (lineCheck == 1) bingoCount++;
        }
        // 대각선 체크
        int lineCheck1 = 1;
        for(int u=0 ; u<5 ; u++){
            lineCheck1 *= check[u][u];
        }
        if (lineCheck1 == 1) bingoCount++;

        int lineCheck2 = 1;
        for(int u=0 ; u<5 ; u++){
            lineCheck2 *= check[u][4-u];
        }
        if (lineCheck2 == 1) bingoCount++;

        if (bingoCount >= 3) isEnd = true;
    }
}

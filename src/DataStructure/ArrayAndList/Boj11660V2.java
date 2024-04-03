package DataStructure.ArrayAndList;

import java.io.*;
import java.util.*;

public class Boj11660V2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N+1][N+1];

        for (int i=1 ; i<=N ; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=1 ; j<=N ; j++) {
                board[i][j] = board[i-1][j] + board[i][j-1] - board[i-1][j-1] + Integer.parseInt(line[j-1]);
            }
        }

        for (int i=0 ; i<M ; i++) {
            String[] tc = br.readLine().split(" ");

            int x1 = Integer.parseInt(tc[0]);
            int y1 = Integer.parseInt(tc[1]);
            int x2 = Integer.parseInt(tc[2]);
            int y2 = Integer.parseInt(tc[3]);

            int answer = board[x2][y2] - board[x2][y1-1] - board[x1-1][y2] + board[x1-1][y1-1];

            System.out.println(answer);
        }
    }
}

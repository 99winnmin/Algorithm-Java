package CJNetworks;

import java.io.*;
import java.util.*;

public class Boj4920 {
    private static int n,max;
    private static int[][] board = new int[101][101];
    private static int[][][] figure = {
        // 1 도형
        {{0,0,0,0}, {0,1,2,3}},
        {{0,1,2,3}, {0,0,0,0}},
        // 2 도형
        {{0, 0, 1, 1}, {0, 1, 1, 2}},
        {{0, 1, 1, 2}, {0, 0, -1, -1}},
        // 3 도형
        {{0, 0, 0, 1}, {0, 1, 2, 2}},
        {{0, 1, 2, 2}, {0, 0, 0, -1}},
        {{0, 1, 1, 1}, {0, 0, 1, 2}},
        {{0, 0, 1, 2}, {0, 1, 0, 0}},
        // 4 도형
        {{0, 1, 1, 1}, {0, -1, 0, 1}},
        {{0, 1, 1, 2}, {0, 0, 1, 0}},
        {{0, 0, 0, 1}, {0, 1, 2, 1}},
        {{0, 1, 1, 2}, {0, -1, 0, 0}},
        // 5 도형
        {{0, 0, 1, 1}, {0, 1, 1, 0}}
    };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testcase = 1;

        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            board = new int[101][101];
            max = Integer.MIN_VALUE;
            for(int i=1 ; i<=n ; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1 ; j<=n ; j++) board[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int i=1 ; i<=n ; i++) {
                for(int j=1 ; j<=n ; j++) {
                    for(int p=0 ; p<figure.length ; p++) {
                        boolean isValid = true;
                        int sum = 0;
                        for(int q=0 ; q<4 ; q++) {
                            int dx = i + figure[p][0][q];
                            int dy = j + figure[p][1][q];
                            // 도형 좌표 중에 벗어난것이 있으면 해당 for 문 취소
                            if (isOut(dx, dy)) {
                                isValid = false;
                                break;
                            }
                            else {
                                sum += board[dx][dy];
                            }
                        }
                        // 해당 도형은 범위를 벗어남
                        if (isValid) max = Math.max(max, sum);
                    }
                }
            }

            sb.append(testcase).append(". ").append(max).append("\n");
            testcase++;
        }

        System.out.println(sb);
    }



    private static boolean isOut(int x, int y) {
        return x<1 || y<1 || x>n || y>n;
    }


}

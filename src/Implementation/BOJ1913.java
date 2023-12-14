package Implementation;

import java.io.*;
import java.util.*;

public class BOJ1913 {

    static int N,target,tx,ty;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        target = sc.nextInt();
        map = new int[N][N];
        int currX = N/2;
        int currY = N/2;
        map[currX][currY] = 1;

        for (int i=1 ; i<N ; i++){
            if (i%2 == 0) { // 아래 -> 왼쪽
                for (int j=0 ; j<i ; j++){
                    int temp = map[currX][currY];
                    currX++;
                    map[currX][currY] = temp+1;
                }
                for (int j=0 ; j<i ; j++){
                    int temp = map[currX][currY];
                    currY--;
                    map[currX][currY] = temp+1;
                }
            } else { // 위 -> 오른쪽
                for (int j=0 ; j<i ; j++){
                    int temp = map[currX][currY];
                    currX--;
                    map[currX][currY] = temp+1;
                }
                for (int j=0 ; j<i ; j++){
                    int temp = map[currX][currY];
                    currY++;
                    map[currX][currY] = temp+1;
                }
            }
        }
        for (int i=1 ; i<N ; i++){
            int temp = map[currX][currY];
            currX--;
            map[currX][currY] = temp+1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<N ; i++){
            for (int j=0 ; j<N ; j++){
                if (map[i][j] == target) {
                    tx = i+1;
                    ty = j+1;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(tx).append(" ").append(ty);

        System.out.println(sb);
    }
}

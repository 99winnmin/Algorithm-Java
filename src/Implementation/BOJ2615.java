package Implementation;
import java.io.*;
import java.util.*;

public class BOJ2615 {
    static int[][] board = new int[19][19];
    static boolean isSearch = false;
    static int depth;
    static int[] dx = new int[]{-1,-1,0,1,1,1,0,-1};
    static int[] dy = new int[]{0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0 ; i<19 ; i++){
            String[] nums = br.readLine().split(" ");
            for(int j=0 ; j<19 ; j++){
                board[i][j] = Integer.parseInt(nums[j]);
            }
        }

        for(int i=0 ; i<19 ; i++){
            for(int j=0 ; j<19 ; j++){
                if(board[i][j] == 0) continue;
                for(int k=0 ; k<4 ; k++){
                    int[] direction1 = new int[]{dx[k], dy[k]};
                    int[] direction2 = new int[]{dx[k+4], dy[k+4]};
                    depth = 1;
                    DFS(i,j,direction1);
                    DFS(i,j,direction2);
                    if(depth == 5) {
                        System.out.println(board[i][j]);
                        if (k == 0 || k == 3){
                            System.out.println((i+1) + " " + (j+1));
                            return;
                        } else if(k == 1){
                            int a = i+1+4 > 19 ? 19 : i+1+4;
                            int b = j+1-4 < 1 ? 1 : j+1-4;
                            System.out.println(a + " " + b);
                            return;
                        } else if(k == 2){
                            // 왼쪽 끝인 경우
                            if(j+1 >= 1 && board[i][j-1] != board[i][j]){
                                System.out.println((i+1) + " " + (j+1));
                                return;
                            }
                            // 오른쪽 끝인 경우
                            if(j+1 <= 19 && board[i][j+1] != board[i][j]){
                                int b = j+1-4 < 1 ? 1 : j+1-4;
                                System.out.println((i+1) + " " + b);
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("0");
    }

    static void DFS(int x, int y, int[] direction){
        int nextX = x+direction[0];
        int nextY = y+direction[1];
        if(isOut(nextX, nextY)) return;
        if(board[nextX][nextY] == board[x][y]) {
            depth += 1;
//            System.out.println(x + " " + y + " |||| " + nextX + " " + nextY);
            DFS(nextX, nextY, direction);
        } else {
            return;
        }
    }

    static boolean isOut(int x, int y){
        return x<0 || y<0 || x>=19 || y>=19;
    }


}

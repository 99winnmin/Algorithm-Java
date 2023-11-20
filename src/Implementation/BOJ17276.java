package Implementation;
import java.io.*;
import java.util.*;

public class BOJ17276 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T,N,d;
    static int[][] board;
    static int[][] temp;
    static ArrayList<Integer>[] lines = new ArrayList[4];
    public static void main(String[] args) throws Exception {
        init();
        for(int t=0 ; t<T ; t++){
            initPerCase();
            solution();
            print();
        }
    }

    private static void init() throws Exception {
        T = Integer.parseInt(br.readLine());
    }

    private static void initPerCase() throws Exception {
        String[] nd = br.readLine().split(" ");
        N = Integer.parseInt(nd[0]);
        d = Integer.parseInt(nd[1]);
        board = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String[] nums = br.readLine().split(" ");
            int index = 0;
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(nums[index++]);
            }
        }
    }

    private static void print(){
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void solution(){
        if(Math.abs(d) % 360 == 0) return;
        temp = new int[N+1][N+1];
        for(int k=0 ; k<4 ; k++) lines[k] = new ArrayList<>();

        for(int u=1 ; u<=N ; u++){
            for(int v=1 ; v<=N ; v++){
                if(u==v) lines[0].add(board[u][v]);
                if (v == (N/2)+1) lines[1].add(board[u][v]);
                if (u+v == N+1) lines[2].add(board[u][v]);
                if (u == (N/2)+1) lines[3].add(board[u][v]);
            }
        }

        if(d > 0){
            d = d%360;
            int rCount = Math.abs(d)/45;
            if(rCount <= 4)
                rotation(rCount);
            else
                reverseRotation(8-rCount);
        } else {
            d = Math.abs(d)%360;
            int rCount = Math.abs(d)/45;
            if(rCount <= 4)
                reverseRotation(rCount);
            else
                rotation(8-rCount);
        }
    }

    private static void rotation(int rotate){
        if (rotate == 1){
            for(int u=1 ; u<=N ; u++){
                for(int v=1 ; v<=N ; v++){
                    if(u==v) temp[u][v] = lines[3].remove(0);
                    if (v == (N/2+1)) temp[u][v] = lines[0].remove(0);
                    if (u+v == N+1) temp[u][v] = lines[1].remove(0);
                    if (u == (N/2)+1) temp[u][v] = lines[2].remove(lines[2].size()-1);
                }
            }
        } else if (rotate == 2){ // 90도 회전
            for(int u=1 ; u<=N ; u++){
                for(int v=1 ; v<=N ; v++){
                    if(u==v) temp[u][v] = lines[2].remove(lines[2].size()-1);
                    if (v == (N/2+1)) temp[u][v] = lines[3].remove(0);
                    if (u+v == N+1) temp[u][v] = lines[0].remove(0);
                    if (u == (N/2)+1) temp[u][v] = lines[1].remove(lines[1].size()-1);
                }
            }
        } else if (rotate == 3) {
            for(int u=1 ; u<=N ; u++){
                for(int v=1 ; v<=N ; v++){
                    if(u==v) temp[u][v] = lines[1].remove(lines[1].size()-1);
                    if (v == (N/2+1)) temp[u][v] = lines[2].remove(lines[2].size()-1);
                    if (u+v == N+1) temp[u][v] = lines[3].remove(0);
                    if (u == (N/2)+1) temp[u][v] = lines[0].remove(lines[0].size()-1);
                }
            }
        } else { // 180도 회전
            for(int u=1 ; u<=N ; u++){
                for(int v=1 ; v<=N ; v++){
                    if(u==v) temp[u][v] = lines[0].remove(lines[0].size()-1);
                    if (v == (N/2+1)) temp[u][v] = lines[1].remove(lines[1].size()-1);
                    if (u+v == N+1) temp[u][v] = lines[2].remove(lines[2].size()-1);
                    if (u == (N/2)+1) temp[u][v] = lines[3].remove(lines[3].size()-1);
                }
            }
        }

        for(int u=1 ; u<=N ; u++){
            for(int v=1 ; v<=N ; v++){
                if(temp[u][v] != 0 && temp[u][v] != board[u][v]) board[u][v] = temp[u][v];
            }
        }
    }

    private static void reverseRotation(int rotate){
        if (rotate == 1){
            for(int u=1 ; u<=N ; u++){
                for(int v=1 ; v<=N ; v++){
                    if(u==v) temp[u][v] = lines[1].remove(0);
                    if (v == (N/2+1)) temp[u][v] = lines[2].remove(0);
                    if (u+v == N+1) temp[u][v] = lines[3].remove(lines[3].size()-1);
                    if (u == (N/2)+1) temp[u][v] = lines[0].remove(0);
                }
            }
        } else if (rotate == 2){ // 90도 회전
            for(int u=1 ; u<=N ; u++){
                for(int v=1 ; v<=N ; v++){
                    if(u==v) temp[u][v] = lines[2].remove(0);
                    if (v == (N/2+1)) temp[u][v] = lines[3].remove(lines[3].size()-1);
                    if (u+v == N+1) temp[u][v] = lines[0].remove(lines[0].size()-1);
                    if (u == (N/2)+1) temp[u][v] = lines[1].remove(0);
                }
            }
        } else if (rotate == 3) {
            for(int u=1 ; u<=N ; u++){
                for(int v=1 ; v<=N ; v++){
                    if(u==v) temp[u][v] = lines[3].remove(lines[3].size()-1);
                    if (v == (N/2+1)) temp[u][v] = lines[0].remove(lines[0].size()-1);
                    if (u+v == N+1) temp[u][v] = lines[1].remove(lines[1].size()-1);
                    if (u == (N/2)+1) temp[u][v] = lines[2].remove(0);
                }
            }
        } else { // 180도 회전
            for(int u=1 ; u<=N ; u++){
                for(int v=1 ; v<=N ; v++){
                    if(u==v) temp[u][v] = lines[0].remove(lines[0].size()-1);
                    if (v == (N/2+1)) temp[u][v] = lines[1].remove(lines[1].size()-1);
                    if (u+v == N+1) temp[u][v] = lines[2].remove(lines[2].size()-1);
                    if (u == (N/2)+1) temp[u][v] = lines[3].remove(lines[3].size()-1);
                }
            }
        }
        for(int u=1 ; u<=N ; u++){
            for(int v=1 ; v<=N ; v++){
                if(temp[u][v] != 0 && temp[u][v] != board[u][v]) board[u][v] = temp[u][v];
            }
        }
    }

}

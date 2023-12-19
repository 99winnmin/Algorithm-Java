package Implementation;
import java.io.*;
import java.util.*;
public class BOJ16935 {
    static int N,M,R;
    static int[] rounds;
    static int[][] board;
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
        R = Integer.parseInt(firstLine[2]);

        board = new int[N][M];
        rounds = new int[R];

        for (int i=0 ; i<N ; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0 ; j<M ; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        String[] line = br.readLine().split(" ");
        for (int i=0 ; i<R ; i++) {
            rounds[i] = Integer.parseInt(line[i]);
        }

    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<M ; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void solution() {
        for (int r=0 ; r<R ; r++) {
            if (rounds[r] == 1) fun1();
            else if (rounds[r] == 2) fun2();
            else if (rounds[r] == 3) fun3();
            else if (rounds[r] == 4) fun4();
            else if (rounds[r] == 5) fun5();
            else fun6();
        }
    }

    private static void fun1() {
        int[][] temp = new int[N][M];
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<M ; j++) {
                temp[i][j] = board[N-i-1][j];
            }
        }
        board = temp;
    }

    private static void fun2() {
        int[][] temp = new int[N][M];
        for (int i=0 ; i<M ; i++) {
            for (int j=0 ; j<N ; j++) {
                temp[j][i] = board[j][M-i-1];
            }
        }
        board = temp;
    }
    private static void fun3() {
        int[][] temp = new int[M][N];
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<M ; j++) {
                temp[j][N-i-1] = board[i][j];
            }
        }
        int t = N;
        N = M;
        M = t;
        board = temp;
    }
    private static void fun4() {
        int[][] temp = new int[M][N];
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<M ; j++) {
                temp[M-j-1][i] = board[i][j];
            }
        }
        int t = N;
        N = M;
        M = t;
        board = temp;
    }
    private static void fun5() {
        int[][] temp = new int[N][M];
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<M ; j++) {
                // 1 2 3 4
                if (i<N/2 && j < M/2) temp[i][j+M/2] = board[i][j];
                else if (i<N/2 && j >= M/2) temp[i+N/2][j] = board[i][j];
                else if (i>=N/2 && j >= M/2) temp[i][j-M/2] = board[i][j];
                else temp[i-N/2][j] = board[i][j];
            }
        }
        board = temp;
    }
    private static void fun6() {
        int[][] temp = new int[N][M];
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<M ; j++) {
                // 1 2 3 4
                if (i<N/2 && j < M/2) temp[i+N/2][j] = board[i][j];
                else if (i<N/2 && j >= M/2) temp[i][j-M/2] = board[i][j];
                else if (i>=N/2 && j >= M/2) temp[i-N/2][j] = board[i][j];
                else temp[i][j+M/2] = board[i][j];
            }
        }
        board = temp;
    }
}

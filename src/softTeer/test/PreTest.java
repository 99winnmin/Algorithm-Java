package softTeer.test;
import java.io.*;
import java.util.*;

public class PreTest {
    static boolean[][] visited;
    static int[][] area;
    static int N,size;
    static int count = 0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String[] nums = br.readLine().split(" ");
            for(int j=0 ; j<N ; j++){
                int n = Integer.parseInt(nums[j]);
                if(n == 1) area[i][j] = n;
            }
        }

        ArrayList<Integer> sizeList = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0 ; j<N ; j++){
                if(!visited[i][j] && area[i][j] == 1) {
                    count++;
                    size = 0;
                    BFS(i,j);
                    sizeList.add(size);
                }
            }
        }

        System.out.println(count);
        if(count != 0){
            Collections.sort(sizeList);
            sizeList.forEach(size -> System.out.print(size + " "));
        }
    }

    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        size += 1;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for(int h=0 ; h<4 ; h++){
                int nextX = curr[0]+dx[h];
                int nextY = curr[1]+dy[h];
                if(!isOut(nextX, nextY) && !visited[nextX][nextY] && area[nextX][nextY] == 1){
                    size += 1;
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    static boolean isOut(int x, int y){
        return x<0 || y<0 || x>=N || y>=N;
    }
}

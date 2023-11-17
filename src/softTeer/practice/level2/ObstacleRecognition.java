package softTeer.practice.level2;
import java.io.*;
import java.util.*;

public class ObstacleRecognition {
    static int N,size;
    static int count = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0 ; i<N ; i++){
            String[] st = br.readLine().split("");
            for(int j=0 ; j<N ; j++){
                int n = Integer.parseInt(st[j]);
                if (n == 1) map[i][j] = 1;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    size = 0;
                    count++;
                    BFS(i, j);
                    answer.add(size);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(count);
        if(count != 0)
            answer.forEach(a -> System.out.println(a));
    }

    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        size += 1;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for(int k=0 ; k<4 ; k++){
                int nextX = curr[0]+dx[k];
                int nextY = curr[1]+dy[k];
                if(!isOut(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 1){
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    size += 1;
                }
            }
        }
    }

    static boolean isOut(int x, int y){
        return x<0 || y<0 || x>=N || y>=N;
    }
}

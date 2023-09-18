package Implementation;

import java.io.*;
import java.util.*;

class IceBerg{
    int x;
    int y;
    IceBerg(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Boj2573 {
    static int[] rangeX = {-1, 0, 1, 0};
    static int[] rangeY = {0, 1, 0, -1};

    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        // DFS + BFS 합성 문제
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int iceBergCnt = 0;

        // 총 빙하 갯수를 먼저 카운트
        while((iceBergCnt = IceBergCount()) < 2){
            if(iceBergCnt == 0){
                ans = 0;
                break;
            }

            Melt(); // 1년 보내기
            ans++;
        }

        br.close();
        System.out.println(ans);
    }

    // 빙하 갯수 세기 (DFS 필요 - 주변에 연결된 것이 있다면 끝까지 트래킹해야해서)
    public static int IceBergCount() {
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    DFS(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // DFS
    public static void DFS(int x, int y, boolean[][] visited){
        visited[x][y] = true; // true 면 이미 들렀음

        int dx, dy;
        for(int i=0 ; i<4 ; i++){
            dx = x + rangeX[i];
            dy = y + rangeY[i];

            if(dx < 0 || dy < 0 || dx >= N || dy >= M) continue;
            if(map[dx][dy] != 0 && !visited[dx][dy]) {
                DFS(dx, dy, visited);
            }
        }
    }

    // 빙하 녹이기 (BFS 사용 - 계속 인접 빙하를 파고드는게 아니라 주변 빙하를 계속 탐색해야하기 때문에 BFS 채택)
    public static void Melt(){
        Queue<IceBerg> queue = new LinkedList<>();

        // visited 로 같은 해에 이미 녹아버린 것에 대해서는 고려x
        boolean[][] visited = new boolean[N][M];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if (map[i][j] != 0){ // 빙하가 있는 곳만 관심 있음
                    queue.offer(new IceBerg(i,j));
                    visited[i][j] = true;
                }
            }
        }

        int dx, dy;
        while(!queue.isEmpty()){
            IceBerg ice = queue.poll(); // 맨앞에 값 리턴하고 제거

            int sea = 0;

            for(int i=0 ; i<4 ; i++){ // 주변 바다 갯수 세기
                dx = ice.x + rangeX[i];
                dy = ice.y + rangeY[i];

                if(dx < 0 || dy < 0 || dx >= N || dy >= M) continue;

                // 애초에 바다였던 것만 체크
                if(!visited[dx][dy] && map[dx][dy] == 0) sea++;
            }

            if(map[ice.x][ice.y] - sea < 0){
                map[ice.x][ice.y] = 0;
            } else {
                map[ice.x][ice.y] -= sea;
            }
        }
    }

}

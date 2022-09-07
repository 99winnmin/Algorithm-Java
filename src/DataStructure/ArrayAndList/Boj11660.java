package DataStructure.ArrayAndList;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] graph = new int[N + 1][N + 1]; // 구간 합으로 할 것이기 때문에

        for (int i = 1; i <= N; i++) { // 원본 배열 저장
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[][] psGraph = new int[N + 1][N + 1];
        // 구간합[i][j] = 구간합[i][j-1] + 구간합[i-1][j] - 구간합[i-1][j-1] + 원본[i][j]
        for (int i = 1; i <= N; i++) { // 구간합 더하기
            for (int j = 1; j <= N; j++) {
                psGraph[i][j] = psGraph[i - 1][j] + psGraph[i][j - 1] + graph[i][j] - psGraph[i - 1][j - 1];
            }
        }
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());
            int result = psGraph[x2][y2] + psGraph[x1 - 1][y1 - 1] - psGraph[x1 - 1][y2] - psGraph[x2][y1 - 1];
            System.out.println(result);
        }
    }
}

package softTeer.test;
import java.io.*;
import java.util.*;

public class Q1Y2022 {
    static int N, step, currStep = 0;
    static int[][] map;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        init();
        solution();
        print();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        step = Math.getExponent(N);
        for(int i=1 ; i<=N ; i++){
            String[] nums = br.readLine().split("");
            for(int j=1 ; j<=N ; j++){
                int n = Integer.parseInt(nums[j-1]);
                if (n == 1) map[i][j] = 1;
            }
        }
    }

    private static void print(){
        System.out.print(answer);
    }

    private static void solution(){
        if (!allSame(1,1)){
            divide(1,1);
        } else {
            if(map[1][1] == 1) answer.append("1");
            else answer.append("0");
        }

    }

    private static void divide(int x, int y){
        currStep++;
        answer.append("(");

        if (step == currStep) { // 끝까지 갔을 때
            answer.append(map[x][y]);
            answer.append(map[x][y+1]);
            answer.append(map[x+1][y]);
            answer.append(map[x+1][y+1]);
            answer.append(")");
            return;
        } else { // 한 섹션에서 끝까지 감
            int x1 = x; int y1 = y; int x2 = x+(int)Math.pow(2, step-currStep); int y2 = y+(int)Math.pow(2, step-currStep);
            if (!allSame(x1,y1)){
                divide(x1,y1);
                currStep--;
            } else {
                if(map[x1][y1] == 1) answer.append("1");
                else answer.append("0");
            }

            if (!allSame(x1,y2)){
                divide(x1,y2);
                currStep--;
            } else {
                if(map[x1][y2] == 1) answer.append("1");
                else answer.append("0");
            }

            if (!allSame(x2,y1)){
                divide(x2,y1);
                currStep--;
            } else {
                if(map[x2][y1] == 1) answer.append("1");
                else answer.append("0");
            }

            if (!allSame(x2,y2)){
                divide(x2,y2);
                currStep--;
            } else {
                if(map[x2][y2] == 1) answer.append("1");
                else answer.append("0");
            }

            answer.append(")");

        }

    }

    private static boolean allSame(int x, int y){
        int curr = map[x][y];
        boolean isSame = true;
        int endX = x + ((int)Math.pow(2, step-currStep)-1);
        int endY = y + ((int)Math.pow(2, step-currStep)-1);

        for(int i=x ; i<=endX ; i++){
            for(int j=y ; j<=endY ; j++){
                if(curr != map[i][j]) return false;
            }
        }
        return isSame;
    }

}

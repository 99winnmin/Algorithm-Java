package CJNetworks;

import java.util.*;

class PG43105 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int h = triangle.length;
        for(int i=h-1 ; i>0 ; i--) {
            for(int j=0 ; j<=triangle[i].length-2 ; j++) {
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }
        return triangle[0][0];
    }
}

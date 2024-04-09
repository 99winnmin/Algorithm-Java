package Tree;

import java.io.*;
import java.util.*;

public class Boj9934 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int h = Integer.parseInt(st.nextToken());
        String[] trees = br.readLine().split(" ");
        int total = trees.length;
        int jump = 0;
        for (int i=0 ; i<h ; i++) {
            int limit = (int)Math.pow(2,i);
            int start = total/2;
            int idx = start;
            for (int j=1 ; j<=limit ; j++) {
                sb.append(trees[idx]).append(" ");
                idx += jump;
            }
            total = total/2;
            jump = start+1;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

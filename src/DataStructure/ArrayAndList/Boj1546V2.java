package DataStructure.ArrayAndList;

import java.io.*;
import java.util.*;

public class Boj1546V2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.MIN_VALUE;
        double total = 0.0;

        String[] scores = br.readLine().split(" ");

        for (String strScore : scores) {
            int score = Integer.parseInt(strScore);
            if (score >= M) M = score;
            total += (double)score;
        }

        System.out.println(total/M*100/N);
    }
}

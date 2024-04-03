package DataStructure.ArrayAndList;

import java.io.*;
import java.util.*;

public class Boj11659V2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] numList = br.readLine().split(" ");
        int[] S = new int[N+1];

        for (int i=1 ; i<=N ; i++) {
            S[i] = S[i-1] + Integer.parseInt(numList[i-1]);
        }

        for (int i=0 ; i<M ; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            System.out.println(S[end] - S[start-1]);
        }
    }
}

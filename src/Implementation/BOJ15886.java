package Implementation;

import java.io.*;
import java.util.*;

public class BOJ15886 {
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] map = br.readLine().split("");
        boolean start = false;
        for (int i=0 ; i<N ; i++) {
            if (map[i].equals("E")) {
                start = true;
            } else {
                if (start) answer++;
                start = false;
            }
        }
        System.out.println(answer);
    }
}

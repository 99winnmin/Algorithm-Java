package softTeer.practice.level1;

import java.util.*;
import java.io.*;

public class WorkTime {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        for(int i=0 ; i<5 ; i++){
            String[] time = br.readLine().split(" ");
            String[] start = time[0].split(":");
            String[] end = time[1].split(":");
            int[] hm = new int[]{Integer.parseInt(start[0]),Integer.parseInt(start[1]),Integer.parseInt(end[0]),Integer.parseInt(end[1])};
            answer += (hm[2] - hm[0])*60;
            if (hm[3] >= hm[1]){
                answer += hm[3] - hm[1];
            } else {
                answer -= hm[1] - hm[3];
            }
        }
        System.out.println(answer);
    }
}

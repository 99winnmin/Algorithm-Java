package DataStructure.ArrayAndList;

import java.io.*;
import java.util.*;
public class Boj11720V2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
//        String[] numList = st.nextToken().split("");
        char[] numList = st.nextToken().toCharArray();

//        for(String num : numList) {
//            answer += Integer.parseInt(num);
//        }

        for(char num : numList) {
            answer += num - '0';
        }

        System.out.println(answer);
    }

}

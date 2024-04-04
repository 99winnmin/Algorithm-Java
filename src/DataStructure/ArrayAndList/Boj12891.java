package DataStructure.ArrayAndList;

import java.io.*;
import java.util.*;

public class Boj12891 {
    private static int S, P, check, count; // check 가 4가 될때마다 count 값 증가
    private static char[] arr;
    private static final int[] temp = new int[4];
    private static final int[] target = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        check = 0;
        count = 0;
        arr = new char[S];
        arr = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<4 ; i++) {
            target[i] = Integer.parseInt(st.nextToken());
            // 체크 조건이 0이면 체크 안해도되니까
            if (target[i] == 0) check++;
        }

        // 초기 상태 만들고 체크해보기
        for (int i=0 ; i<P ; i++) {
            add(arr[i]);
        }

        if (check == 4) count++;

        for (int i=P ; i<S ; i++) {
            // 앞칸 하나 지우고 뒷칸 하나 추가하기
            int first = i-P;
            add(arr[i]);
            remove(arr[first]);
            if (check == 4) count++;
        }

        System.out.println(count);

    }

    private static void add(char c) {
        if (c == 'A') {
            temp[0]++;
            if (target[0] == temp[0]) check++;
        } else if (c == 'C') {
            temp[1]++;
            if (target[1] == temp[1]) check++;
        } else if (c == 'G') {
            temp[2]++;
            if (target[2] == temp[2]) check++;
        } else if (c == 'T') {
            temp[3]++;
            if (target[3] == temp[3]) check++;
        }
    }

    private static void remove(char c) {
        if (c == 'A') {
            if (temp[0] == target[0]) check--;
            temp[0]--;
        } else if (c == 'C') {
            if (temp[1] == target[1]) check--;
            temp[1]--;
        } else if (c == 'G') {
            if (temp[2] == target[2]) check--;
            temp[2]--;
        } else if (c == 'T') {
            if (temp[3] == target[3]) check--;
            temp[3]--;
        }
    }
}

package Search;

import java.io.*;
import java.util.*;

public class BOJ1920 {
    static int N,M;
    static int[] nList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nList = new int[N];
        for(int i=0 ; i<N ; i++){
            nList[i] = sc.nextInt();
        }
        Arrays.sort(nList);

        M = sc.nextInt();
        for(int i=0 ; i<M ; i++){
            int tNum = sc.nextInt();
            BNSearch(tNum);
        }
    }

    public static void BNSearch(int tNum){
        boolean isSearch = false;
        int start = 0;
        int end = nList.length - 1;
        while(start <= end){
            int midIndex = (start + end) / 2;
            int midValue = nList[midIndex];
            if(midValue > tNum) {
                end = midIndex - 1;
            } else if (midValue < tNum){
                start = midIndex + 1;
            } else {
                isSearch = true;
                break;
            }
        }
        if (isSearch) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

}

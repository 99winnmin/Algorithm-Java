package Greedy;

import java.io.*;
import java.util.*;

public class BOJ1541 {
    static int total = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // - 기준으로 다 짜르고 블록들은 모두 더하기 그 다음에 처음 값 더하고 그 이후부터 빼기
        String[] str = input.split("-");

        for(int i=0 ; i<str.length ; i++){
            int temp = mySum(str[i]);
            if(i==0) total += temp;
            else total -= temp;
        }

        System.out.println(total);
    }

    static int mySum(String a){
        int sum = 0;
        String temp[] = a.split("[+]");
        for(String n : temp){
            sum += Integer.parseInt(n);
        }
        return sum;
    }
}

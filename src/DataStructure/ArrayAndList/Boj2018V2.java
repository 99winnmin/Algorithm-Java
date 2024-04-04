package DataStructure.ArrayAndList;

import java.io.*;
import java.util.*;

public class Boj2018V2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;

        while(endIdx != N) {
            if (N == sum) {
                endIdx++;
                count++;
                sum += endIdx;
            } else if (sum > N) {
                sum -= startIdx;
                startIdx++;
            } else { // sum < N
                endIdx++;
                sum += endIdx;
            }
        }

        System.out.println(count);
    }
}

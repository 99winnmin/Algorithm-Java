package Sort;

import java.io.*;
import java.util.*;

public class Boj1427 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        int size = input.length;
        int[] nums = new int[size];

        for (int i=0 ; i<size ; i++ ) {
            nums[i] = Integer.parseInt(input[i]);
        }

        for (int i=0 ; i<size ; i++) {
            int max = nums[i];
            int idx = i;
            for (int j=i ; j<size ; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                    idx = j;
                }
            }
            nums[idx] = nums[i];
            nums[i] = max;
        }

        for (int i=0 ; i<size ; i++ ) {
            System.out.print(nums[i]);
        }

//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        for (String num : input) {
//            pq.add(Integer.parseInt(num));
//        }
//        pq.stream().forEach(System.out::print);
    }
}

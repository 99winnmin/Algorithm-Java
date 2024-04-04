package DataStructure.ArrayAndList;

import java.io.*;
import java.util.*;

public class Boj1940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int count = 0;

        List<Integer> temp = new ArrayList<>();
        for (int i=0 ; i<N ; i++) {
            temp.add(Integer.parseInt(inputs[i]));
        }
        Collections.sort(temp);

        int[] parts = temp.stream().mapToInt(i -> i).toArray();
        int startIdx = 0;
        int endIdx = N-1;
        while (true) {
            if (startIdx == endIdx || startIdx > endIdx) break;
            int sum = parts[startIdx] + parts[endIdx];
            if (sum == M) {
                count++;
                startIdx++;
                endIdx--;
            } else if (sum < M) {
                startIdx++;
            } else {
                endIdx--;
            }
        }

        System.out.println(count);
    }
}

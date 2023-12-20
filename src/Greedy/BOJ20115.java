package Greedy;
import java.io.*;
import java.util.*;

public class BOJ20115 {
    static int n;
    static Double answer = 0.0;
    static PriorityQueue<Double> list = new PriorityQueue<Double>();

    public static void main(String[] args) throws Exception {
        init();
        solution();
        print();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new PriorityQueue<Double>();
        String[] nums = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            list.add(Double.parseDouble(nums[i]));
        }
    }

    private static void print() {
        System.out.println(answer);
    }

    private static void solution() {
        while(list.size() > 1) {
            answer += list.poll()/2;
        }
        answer += list.poll();
    }
}

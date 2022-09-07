package DataStructure.ArrayAndList;

import java.util.Scanner;

public class Boj1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Double max = 0.0;
        Double sum = 0.0;
        Double[] nums = new Double[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextDouble();
            if (nums[i] > max) max = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] / max * 100;
            sum += nums[i];
        }
        System.out.println(sum / nums.length);
    }
}

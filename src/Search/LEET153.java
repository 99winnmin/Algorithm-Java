package Search;

import java.util.*;

public class LEET153 {

    static class Solution {
        public int findMin(int[] nums) {
            int min = Integer.MAX_VALUE;
            int start = 0;
            int end = nums.length-1;
            int mid = (start+end)/2;
            min  = binarySearch(start, end, nums);
            return min;
        }

        private static int binarySearch(int start, int end, int[] nums) {
            if(start >= end) return nums[start];
            int mid = (start+end)/2;
            int f = Integer.MAX_VALUE, s = Integer.MAX_VALUE;
            f = Math.min(f,binarySearch(start, mid, nums));
            s = Math.min(s,binarySearch(mid+1, end, nums));
            return Math.min(f,s);
        }
    }
}

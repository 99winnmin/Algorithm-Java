package DataStructure.Hash;
import java.util.*;

public class LEET349 {
    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            Set<Integer> answer = new HashSet<>();
            for(int n : nums1) set.add(n);
            for(int n : nums2) {
                if(set.contains(n)) answer.add(n);
            }
            return answer.stream().mapToInt(i->i).toArray();
        }
    }
}

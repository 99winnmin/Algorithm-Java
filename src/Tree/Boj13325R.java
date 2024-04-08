package Tree;

import java.io.*;
import java.util.*;

public class Boj13325R {
    private static int[] tree;
    private static int h,res = 0;

    // https://loosie.tistory.com/690
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2, h+1)-1;
        tree = new int[size+1];
        st = new StringTokenizer(br.readLine());
        for (int i=2 ; i<=size ; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1,0);
        System.out.println(res);
    }

    private static int dfs(int node, int currH) {
        if (currH == h) {
            res += tree[node];
            return tree[node];
        }
        int left = dfs(node*2, currH+1);
        int right = dfs(node*2+1, currH+1);
        res += tree[node] + Math.abs(left-right);
        return tree[node] + Math.max(left, right);
    }
}

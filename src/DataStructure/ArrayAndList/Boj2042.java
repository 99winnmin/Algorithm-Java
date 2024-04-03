package DataStructure.ArrayAndList;

import java.io.*;
import java.util.*;

public class Boj2042 {
    private static int N,M,K;
    private static long[] arr, tree;

    // 세그먼트 트리 + 구간합
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        tree = new long[calTreeSize() + 1];
        for (int i=1 ; i<=N ; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        initTree(1, N, 1);
        while(true) {
            if(M==0 && K==0) break;
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) { // 구간합 변경
                int idx = Integer.parseInt(st.nextToken());
                long num = Long.parseLong(st.nextToken());

                long dif = num - arr[idx];
                update(1,N,1,idx,dif);
                arr[idx] = num;

                M--;
            } else { // 구간합 구해서 출력
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                long total = tSum(1, N, 1, left, right);
                sb.append(total).append("\n");

                K--;
            }
        }
        System.out.println(sb);
    }

    private static int calTreeSize() {
        int h = (int)Math.ceil(Math.log(N)/Math.log(2))+1;
        return (int)Math.pow(2,h)-1;
    }

    private static long initTree(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start+end)/2;

        return tree[node] = initTree(start, mid, node*2) + initTree(mid+1, end, node*2+1);
    }

    private static void update(int start, int end, int node, int idx, long dif) {
        if (start <= idx && idx <= end) {
            tree[node] += dif;
        } else {
            return;
        }

        if (start == end) return;

        int mid = (start+end)/2;
        update(start, mid, node*2, idx, dif);
        update(mid+1, end, node*2+1, idx, dif);
    }

    private static long tSum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start+end)/2;

        return tSum(start, mid, node*2, left, right) + tSum(mid+1, end, node*2+1, left, right);
    }

}

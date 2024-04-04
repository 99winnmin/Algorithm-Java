package DataStructure.PriorityQueue;

import java.io.*;
import java.util.*;

public class Boj11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Num> pq = new PriorityQueue<>();

        for (int i=0 ; i<N ; i++) {
            int input = sc.nextInt();
            if (input != 0) {
                pq.add(new Num(input, Math.abs(input)));
            } else {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll().num);
                }
            }
        }
    }

    private static class Num implements Comparable<Num> {
        int num;
        int abs;

        public Num(int n, int a) {
            this.num = n;
            this.abs = a;
        }

        @Override
        public int compareTo(Num other) {
            if (this.abs == other.abs) {
                return this.num - other.num;
            }
            return this.abs - other.abs;
        }
    }

}

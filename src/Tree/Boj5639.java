package Tree;

import java.io.*;
import java.util.*;

public class Boj5639 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true) {
            String num = br.readLine();
            if (num == null || num.isEmpty()) break;
            root.insert(Integer.parseInt(num));
        }
        postOrder(root);
    }

    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }

    private static class Node {
        int num;
        Node left, right;
        public Node(int num) {
            this.num = num;
        }

        public void insert(int other) {
            if (this.num < other) {
                if(this.right == null) this.right = new Node(other);
                else this.right.insert(other);
            } else {
                if(this.left == null) this.left = new Node(other);
                else this.left.insert(other);
            }
        }
    }
}

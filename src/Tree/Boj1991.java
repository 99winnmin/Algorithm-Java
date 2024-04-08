package Tree;

import java.io.*;
import java.util.*;

public class Boj1991 {
    private static Node root;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());

        for (int i=0 ; i<total ; i++) {
            st = new StringTokenizer(br.readLine());
            String curr = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            if(i==0) root = new Node(curr);
            if(!left.equals(".")) root.insert(curr, new Node(left), "l");
            if(!right.equals(".")) root.insert(curr, new Node(right), "r");
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    private static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.s);
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.s);
        inOrder(node.right);
    }

    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.s);
    }

    private static class Node {
        String s;
        Node left, right;

        public Node(String s) {
            this.s = s;
        }

        public void insert(String curr, Node add, String lr) {
            if(this.s.equals(curr)) {
                if (lr.equals("l")) this.left = add;
                else this.right = add;
            } else {
                if(this.left != null) this.left.insert(curr, add, lr);
                if(this.right != null) this.right.insert(curr, add, lr);
            }
        }
    }
}

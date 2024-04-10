package DataStructure.Stack;

import java.util.*;

public class LEET20 {

    public boolean isValid(String ss) {
        String[] list = ss.split("");
        if (list.length%2 != 0) return false;

        Stack<String> stack = new Stack<>();

        for(String s : list) {
            if (s.equals("(") || s.equals("{") || s.equals("[")) {
                stack.add(s);
            } else {
                if(stack.isEmpty()) return false;
                String top = stack.pop();
                if (s.equals(")") && !top.equals("(")) {
                    return false;
                } else if (s.equals("}") && !top.equals("{")) {
                    return false;
                } else if (s.equals("]") && !top.equals("[")) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}

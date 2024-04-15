package CJNetworks;

import java.io.*;
import java.util.*;

public class Boj1525R {
    private static String TARGET = "123456780";
    private static int[] dx = new int[]{-1,0,1,0};
    private static int[] dy = new int[]{0,-1,0,1};
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String init = "";

        for(int i=0 ; i<3 ; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0 ; j<3 ; j++) {
                init += input[j];
            }
        }

        map.put(init, 0);
        System.out.println(bfs(init));

    }

    private static int bfs(String init) {
        Queue<String> queue = new LinkedList<>();
        queue.add(init);

        while(!queue.isEmpty()) {
            String curr = queue.poll();
            int count = map.get(curr);
            int idx = curr.indexOf('0');
            int x = idx/3;
            int y = idx%3;

            if (curr.equals(TARGET)) {
                return count;
            }

            for(int i=0 ; i<4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(isOut(nx,ny)) continue;
                // x 축 이동하면 3 칸 옮기는 것이므로
                int nPos = nx*3 + ny;
                char temp = curr.charAt(nPos);
                String change = curr.replace(temp, 'c');
                change = change.replace('0', temp);
                change = change.replace('c','0');

                // 이미 한번 돌았던 문자열이면 체크 안함
                if (!map.containsKey(change)) {
                    queue.add(change);
                    map.put(change, count+1);
                }
            }
        }

        return -1;
    }


    private static boolean isOut(int x, int y) {
        return x<0 || y<0 || x>2 || y>2;
    }
}

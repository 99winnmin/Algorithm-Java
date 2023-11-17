package softTeer.practice.level2;
import java.io.*;
import java.util.*;

public class Accelerator {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer;
        String[] list = br.readLine().split(" ");
        if(list[0].equals("1")) {
            answer = "ascending";
            for(int i=0 ; i<list.length ; i++){
                if(i==0 || i==7) continue;
                if (Integer.parseInt(list[i]) - Integer.parseInt(list[i - 1]) != 1) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println(answer);
        } else if(list[0].equals("8")) {
            answer = "descending";
            for(int i=0 ; i<list.length ; i++){
                if(i==0 || i==7) continue;
                if (Integer.parseInt(list[i]) - Integer.parseInt(list[i - 1]) != -1) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println(answer);
        } else {
            System.out.println("mixed");
            return;
        }
    }
}

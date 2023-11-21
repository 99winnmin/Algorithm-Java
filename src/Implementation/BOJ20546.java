package Implementation;
import java.io.*;
import java.util.*;

public class BOJ20546 {
    private static int[] machineDuck;
    private static int[] upAndDown;
    private static BNP bnp;
    private static TIMING timing;

    public static void main(String[] args) throws Exception {
        init();
        solution();
        print();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer cash = Integer.parseInt(br.readLine());
        bnp = new BNP(cash);
        timing = new TIMING(cash);

        String[] nums = br.readLine().split(" ");
        machineDuck = new int[nums.length];
        upAndDown = new int[nums.length];
        for(int i=0 ; i<nums.length ; i++){
            machineDuck[i] = Integer.parseInt(nums[i]);
        }

        for(int i=1 ; i<nums.length-1 ; i++){
            if (machineDuck[i] > machineDuck[i-1]) {
                if (upAndDown[i-1] < 0 ) upAndDown[i] = 1;
                else upAndDown[i] = upAndDown[i-1] + 1;
            } else if (machineDuck[i] < machineDuck[i-1]) {
                if (upAndDown[i-1] > 0 ) upAndDown[i] = -1;
                else upAndDown[i] = upAndDown[i-1] - 1;
            } else {
                upAndDown[i] = 0;
            }
        }
    }

    private static void solution() {
        for(int i=0 ; i<machineDuck.length ; i++){
            bnp.strategy(i);
            timing.strategy(i);
        }
    }

    private static void print() {
        int bnpTotal = bnp.getMoney();
        int timingTotal = timing.getMoney();
        if (bnpTotal > timingTotal) {
            System.out.println("BNP");
        } else if(bnpTotal < timingTotal){
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    static class BNP {
        Integer cash;
        Integer amount;

        public BNP (Integer cash) {
            this.cash = cash;
            this.amount = 0;
        }

        public void strategy(int date){
            if (this.cash >= machineDuck[date] && this.cash > 0){
                this.amount += this.cash/machineDuck[date];
                this.cash = this.cash%machineDuck[date];
            }
        }

        public Integer getMoney(){
            return this.cash + this.amount*machineDuck[13];
        }

    }

    static class TIMING {
        Integer cash;
        Integer amount;

        public TIMING (Integer cash) {
            this.cash = cash;
            this.amount = 0;
        }

        public void strategy(int date){
            if (upAndDown[date] <= -3 && this.cash > 0){
                this.amount += this.cash/machineDuck[date];
                this.cash = this.cash%machineDuck[date];
            }
            if (upAndDown[date] >= 3){
                this.cash += this.amount*machineDuck[date];
                this.amount = 0;
            }
        }

        public Integer getMoney(){
            return this.cash + this.amount*machineDuck[13];
        }
    }
}

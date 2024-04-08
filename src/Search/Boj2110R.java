package Search;

import java.io.*;
import java.util.*;

public class Boj2110R {
    private static int N,C;
    private static int[] house;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];
        for(int i=0 ; i<N ; i++) {
            int h = Integer.parseInt(br.readLine());
            house[i] = h;
        }
        Arrays.sort(house);

        int start = 1; // 최소 거리가 가질 수 있는 최솟값
        int end = house[N-1] - house[0] + 1; // 최소 거리가 가질 수 있는 최댓값

        // Upper Bound 형식
        while(start < end) {
            int mid = (start+end)/2;
            /*
             * mid 거리에 대해 설치 가능한 공유기 개수가 M 개수에 못미치면
             * 거리를 좁혀야 하기 때문에 end 를 줄인다.
             */
            int installed = install(mid);
            if(installed < C) {
                end = mid;
            }
            else { // installed >= C
                /**
                 * 설치 가능한 공유기 개수가 M 개수보다 크거나 같으면
                 * 거리를 벌리면서 최소거리가 가질 수 있는 최대 거리를
                 * 찾아낸다.
                 */
                start = mid+1;
            }
        }

        System.out.println(start-1);
    }

    private static int install(int dist) {
        // 첫번째 집은 무조건 설치 가정
        int count = 1;
        int last = house[0];

        for (int i=1 ; i<house.length ; i++) {
            int curr = house[i];
            /*
             *  현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가
             *  최소 거리(dist)보다 크거나 같을 때 공유기 설치 개수를 늘려주고
             *  마지막 설치 위치를 갱신해준다.
             */
            if(curr - last >= dist) {
                count++;
                last = curr;
            }
        }
        return count;
    }
}

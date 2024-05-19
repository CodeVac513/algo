package dp;

import java.io.*;
import java.util.Arrays;

public class p2616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //기관차가 끌고 가던 객차의 수 n
        int n = Integer.parseInt(br.readLine());

        // 1번 객차부터 타고 있는 손님의 수를 누적합으로 저장할 배열
        // 1 / 1+2 / 1+2+3 / ... / 1+...+n
        int[] sum = new int[n+1];

        //String 배열로 객차의 손님 수를 순서대로 저장
        String[] temp = br.readLine().split(" ");

        sum[0] = 0;
        //기관차가 끌고 가던 객차에 타고 있는 손님의 수가 1번 객차부터 차례대로 입력.
        for(int i = 1 ; i < n + 1; i++) {
            sum[i] = sum[i - 1]+ Integer.parseInt(temp[i-1]);
        }

        //소형 기관차가 최대로 끌 수 있는 객차의 수, 기관차가 끄는 객차 수의 1/3보다 작다.
        int maximum = Integer.parseInt(br.readLine());

        //dp 배열 생성
        int[][] dp = new int[4][n+1];
        for(int i = 0 ; i < 4;i++) {
            Arrays.fill(dp[i],0);
        }

        for(int i = 1 ; i < 4 ; i++) {
            for(int j = i * maximum ; j <= n ; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-maximum] + sum[j] - sum[j-maximum]);
            }
        }

        bw.write(dp[3][n]+"\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
//    boolean[] checked = new boolean[n];
//        Arrays.fill(checked, false);
//        for(int i = 0 ; i < 3 ; i++) {
//            for(int j = 1 ; j < n - maximum + 2; j++) {
//                if(!checked[j]){
//                    int passengers = 0;
//                    for(int k = 0 ; k < maximum ; k++) {
//                        passengers += passenger[j+k];
//                    }
//                    dp[i][j] = Math.max(dp[i][j-1], passengers);
//                    if(dp[i][j-1] < passengers) {
//                        checked[j-1] = false;
//                        checked[j] = true;
//                        checked[j+1] = true;
//                    }
//                }
//            }
//        }

package dp;

import java.io.*;
import java.util.Arrays;

public class p2624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] coins = new int[k][2];

        for(int i = 0 ; i < k ; i++) {
            String[] temp = br.readLine().split(" ");
            coins[i][0] = Integer.parseInt(temp[0]);
            coins[i][1] = Integer.parseInt(temp[1]);
        }

        int[][] dp = new int[T+1][k];
        //0원을 만들 수 있는 방법을 1로 초기화.
        Arrays.fill(dp[0], 1);
        //나머지 값은 일단 -1로 채운다.
        for(int i = 1; i <= T ; i++) {
            Arrays.fill(dp[i],-1);
        }


        br.close();
        bw.flush();
        bw.close();
    }
}

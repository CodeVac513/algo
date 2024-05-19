package dp;

import java.io.*;

public class p14567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        boolean[][] required = new boolean[N+1][N+1];

        for(int i = 0 ; i < M ; i++) {
            String[] nums = br.readLine().split(" ");
            required[Integer.parseInt(nums[0])][Integer.parseInt(nums[1])] = true;
        }


        int[] dp = new int[N+1];


        for(int i = 1 ; i <= N ; i++ ) {
            dp[i] = 1;
            for (int j = 1; j < i ; j++) {
                if(required[j][i]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        for(int i = 1 ; i <= N ; i++ ) {
            bw.write(dp[i]+" ");
        }

        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

package dp;

import java.io.*;
import java.util.Arrays;

public class p15486 {

    static int[] time;
    static int[] pay;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        time = new int[N+2];
        pay = new int[N+2];

        for(int i = 1 ; i < N + 1 ; i++) {
            String[] temp = br.readLine().split(" ");
            time[i] = Integer.parseInt(temp[0]);
            pay[i] = Integer.parseInt(temp[1]);
        }


        int[] dp = new int[N+2];
        Arrays.fill(dp,0);
        int max = -1;

        for(int i = 1; i <= N+1 ; i++) {
            if(max < dp[i]){
                max = dp[i];
            }
            int nextPerson = i + time[i];
            if(nextPerson < N+2) {
                dp[nextPerson] = Math.max(dp[nextPerson],max+pay[i]);
            }
        }

        bw.write(dp[N+1]+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

}

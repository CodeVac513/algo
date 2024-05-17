package solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1010 {
    static int[][] dp;

    public p1010() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        dp = new int[30][30];

        for(int testCase = 0; testCase < t; ++testCase) {
            String[] nums = br.readLine().split(" ");
            int N = Integer.parseInt(nums[0]);
            int M = Integer.parseInt(nums[1]);
            int ans = combination(M, N);
            bw.write("" + ans + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static int combination(int n, int m) {
        if (dp[n][m] > 0) {
            return dp[n][m];
        } else {
            return n != m && m != 0 ? (dp[n][m] = combination(n - 1, m - 1) + combination(n - 1, m)) : (dp[n][m] = 1);
        }
    }
}

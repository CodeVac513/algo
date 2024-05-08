package solving;

import java.io.*;

public class p1010 {
    //1. 입력 생각하기
    //
    //2. 구현 방법
    // 도저히 모르겠어서 검색했다. => 조합을 이용하는 문제
    // https://en.wikipedia.org/wiki/Binomial_coefficient
    // 주말에 왜 조합을 이용하는지 다시 보자. 보류 문제

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        dp = new int[30][30];

        for(int testCase = 0 ; testCase < t; testCase++) {
            String[] nums = br.readLine().split(" ");
            int N = Integer.parseInt(nums[0]);
            int M = Integer.parseInt(nums[1]);
            int ans = combination(M,N);

            bw.write(ans+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static int combination(int n, int m) {
        if(dp[n][m] > 0) {
            return dp[n][m];
        }

        if(n == m || m == 0) {
            return dp[n][m] = 1;
        }

        return dp[n][m] = combination(n - 1, m - 1) + combination(n - 1 , m);
    }
}

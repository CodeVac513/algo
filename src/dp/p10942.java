package dp;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class p10942 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        String[] temp = br.readLine().split(" ");

        for(int i = 0 ; i < N ; i++ ) {
            nums[i] = Integer.parseInt(temp[i]);
        }
        dp = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            Arrays.fill(dp[i],-1);
        }
        for(int i = 0 ; i < N ; i++) {
            dp[i][i] = 1;
        }

        for(int i = 0 ; i < N-1 ; i++) {
            if(nums[i] == nums[i+1]) {
                dp[i][i+1] = 1;
                dp[i+1][i] = 1;
            }
        }

        isPalindrome(N, nums);
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < M; i++) {
            String[] temp2 = br.readLine().split(" ");
            int s = Integer.parseInt(temp2[0]) - 1;
            int e = Integer.parseInt(temp2[1]) - 1;
            if(dp[s][e] == 1) {
                sb.append(dp[s][e]).append("\n");
            } else {
                sb.append(0).append("\n");
            }

        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void isPalindrome(int N, int[] nums) {

        for(int i = 2 ; i < N; i++) {
            for(int j = 0 ; j < N - i ; j++) {
                if(nums[j] == nums[j+i] && dp[j+1][j+i-1] != -1) {
                    dp[j][j+i] = dp[j+i][j] = 1;
                }
            }
        }

    }
//    static int isPalindrome(String input) {
//        boolean isPal = true;
//        for(int i = 0 ; i < input.length()/2 ; i++) {
//            if(input.charAt(i) != input.charAt(input.length()-(i+1))) {
//                isPal = false;
//                break;
//            }
//        }
//
//        if(isPal) {
//            return 1;
//        }
//        return 0;
//    }
}

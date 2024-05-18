package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class p12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //물건 종류의 갯수 N과 제한 중량 K를 입력받는다.
        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int K = Integer.parseInt(nums[1]);

        //물건의 무게와 가치를 입력받을 struff 매트릭스를 생성한다.
        int[][] stuff = new int[N][2];

        //물건 배열에 w와 v값을 채운다.
        for(int i = 0 ; i < N ; i++) {
            String[] temp = br.readLine().split(" ");
            stuff[i][0] = Integer.parseInt(temp[0]);
            stuff[i][1] = Integer.parseInt(temp[1]);

        }

        //dp는 각 제한 중량일 때 최댓값을 담을 예정이다.
        int[][] dp = new int[N+1][K+1];

        for(int i = 0 ; i < N + 1 ; i++) {
            Arrays.fill(dp[i],0);
        }


        for(int i = 1 ; i < N+1; i++) {
            for(int j = 1 ; j < K+1; j++) {
                if(j >= stuff[i-1][0]) {
                    dp[i][j] = Math.max(dp[i-1][j], stuff[i-1][1] + dp[i-1][j - stuff[i-1][0]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        bw.write(dp[N][K]+"\n");

        br.close();
        bw.flush();
        bw.close();
    }
}

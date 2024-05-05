package dp;

import java.io.*;
import java.util.Arrays;


public class p12865 {
    //1. 구현 생각하기
    //
    //2. 어떤 방법으로 해결할 수 있을까
    // Greedy 인줄 알고 접근했는데 안 풀림.
    // -> knapsack problem이라는 문제 유형
    //
    //
    //**참고
    // knapsack problem이라는 문제 유형인데 물건의 무게를 조정해서 배낭에 채울 수 있다면(fractional knapsack problem)
    // greedy로 해결할 수 있지만
    // 무게 조정이 불가능한 문제(0-1 Knapsack Problem)는 DP나 백트래킹을 이용하여 문제를 해결할 수 있다고 함.

    static int[][] dp;
    static int[] weight;
    static int[] value;
    static int K;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        N = Integer.parseInt(nums[0]);
        K = Integer.parseInt(nums[1]);

        weight = new int[N];
        value = new int[N];
        dp = new int[N][K+1];

        for(int i = 0 ; i  < N ; i++) {
            String[] temp = br.readLine().split(" ");
            weight[i] = Integer.parseInt(temp[0]);
            value[i] = Integer.parseInt(temp[1]);
        }

        for(int[] i : dp) {
            Arrays.fill(i,-1);
        }


        bw.write(knapsack(N - 1, K) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static int knapsack(int i, int v) {
        // i가 0미만으로 범위를 벗아나는 경우 종료
        if(i < 0)
            return 0;
        if(i==0 && v==0) {
            dp[i][v] = 0;
            return 0;
        }

        // dp배열에서 -1로 초기화되어 있는 경우는 탐색하지 않은 위치
        if(dp[i][v] == -1) {

            // 현재 i번째 물건을 못 담는 경우
            if(weight[i] > v) {
                dp[i][v] = knapsack(i-1, v);
            } else {
                // 현재 i번째 물건을 담을 수 있는 경우
                // 이전 i값과 이전 i값에 대한 v-weight[i]의 값 + 현재 가치(value[i]) 중 큰 값을 저장한다.
                dp[i][v] = Math.max(knapsack(i-1,v), knapsack(i-1,v-weight[i]) + value[i]);
            }
        }
        return dp[i][v];
    }
}

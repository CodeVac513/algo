package dp;

import java.io.*;
import java.util.Arrays;

public class p5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //상근이가 입력받을 숫자의 갯수 N
        int N = Integer.parseInt(br.readLine());

        //0이상 9이하의 정수 N개가 공백으로 구분되어 배열에 저장.
        String[] numStr = br.readLine().split(" ");

        //숫자를 배열에 입력 순서대로 저장
        int[] nums = new int[N];
        int index = 0;
        for(String str: numStr) {
            nums[index++] = Integer.parseInt(str);
        }

        Long[][] dp = new Long[N][21];
        for(int i = 0 ; i < N ; i++) {
            Arrays.fill(dp[i],0L);
        }
        dp[0][nums[0]] = 1L;

        int plus;
        int minus;

        // 만들 수 있는 숫자에 계속 표시를 해서 더하거나 빼다보면
        // 언젠가는 nums의 마지막 숫자에도 1씩 계속 올라가서(혹은 못 만들면 0이겠지)
        // dp 배열의 [N-2][nums의 마지막 숫자인 nums[N-1]]를 진행하면 답이 나온다.
        // (=이 붙는 바로 앞 숫자번까지 루프를 돌았을 때 결과 값이 N-2번째에 저장되겠지)
        for(int i = 1 ; i < N - 1; i++) {
            for(int j = 0 ; j <= 20 ; j++) {
                if(dp[i-1][j] != 0L) {
                    plus = j + nums[i];
                    minus = j - nums[i];
                    if(plus >= 0 && plus <= 20) {
                        dp[i][plus] += dp[i-1][j];
                    }

                    if(minus >= 0 && minus <= 20) {
                        dp[i][minus] += dp[i-1][j];
                    }
                }
            }
        }

        bw.write(dp[N-2][nums[N-1]]+"\n");

        br.close();
        bw.flush();
        bw.close();
    }
}

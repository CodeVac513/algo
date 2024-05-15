package solving;

import java.io.*;
import java.util.Arrays;

@SuppressWarnings("Ignore LoopWarning")
public class p2624 {
    // 1. 입력 생각하기
    // int 범위를 생각할 정도의 문제는 아닌 것 같다.
    // 평범하게 int형을 사용하면 될 것 같다.
    // T원의 지폐를 동전으로 바꿔주는데, k가지의 동전이 n1, n2, ... , nk 개씩 들어있다.
    // 동전의 금액은 p1, p2, ... , pk로 주어지고 이 지폐를 동전으로 교환하는데 몇 가지의 방법이 나오는지
    // 출력해야 한다.
    // 2. 구현 생각하기
    // 가장 직관적으로 떠오른 방법은 greedy를 사용하는 것이다.
    // 가장 가치가 큰 것부터 채우고, 되면 ans++
    // 안되면 다음으로 넘기고 가치가 가장 낮은 동전까지 왔을 때까지 ans를 계산하고 마지막에 출력
    // 근데 코드를 작성하다 보니까 greedy로 풀면 이중,삼중으로 중첩된 반복문이 나올 것 같다.
    // => dp를 사용하는 문제
    //https://bacchus-lover.tistory.com/315
    //풀이는 여기 보고 풀었는데 DP 감이 너무 안잡힌다. 어떡하냐 ㅋㅋ...
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        dp = new int[T+1][k];
        //0원을 만들 수 있는 방법을 1로 초기화.
        Arrays.fill(dp[0], 1);
        //나머지 값은 일단 -1로 채운다.
        for(int i = 1; i <= T ; i++) {
            Arrays.fill(dp[i],-1);
        }


        //동전의 종류와 갯수를 각각 coin[k][0], coin[k][1]에 저장한다.
        int[][] coin = new int[k][2];

        for(int i = 0 ; i < k ; i++) {
            String[] temp = br.readLine().split(" ");
            coin[i][0] = Integer.parseInt(temp[0]);
            coin[i][1] = Integer.parseInt(temp[1]);
        }

        int ans = cal(T,k-1,coin);
        bw.write(ans+"\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static int cal(int T, int index, int[][] coin) {
        if(T == 0) {
            return 1;
        }

        if(index < 0) {
            return 0;
        }
        if(dp[T][index] != -1) {
            return dp[T][index];
        }
        int result = 0;
        for (int i = 0 ; i<= coin[index][1] ; i++) {
            int remainder = T - coin[index][0] * i;
            if(remainder >= 0) {
                result += cal(remainder, index-1,coin);
            }
        }
        return dp[T][index] = result;
    }
}

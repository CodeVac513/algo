package dp;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p14567 {
    // 1. 입력 생각하기
    // 과목의 수 N과 선수 조건의 수 M(선수 과목의 갯수)이 동시에 입력
    // 선수 과목은 A B가 입력되었을 때 A가 B의 선수 과목이다. A<B인 경우만 주어진다.
    // 2. 구현 생각하기
    // 1번부터 N번까지 차례대로 최소 몇 학기에 이수할 수 있는지 한 줄에 공백으로 구분하여 출력한다.
    // (A,B)를 저장하는 큐를 만든다
    // int[] lectures를 DP에 사용한다.
    // 모든 과목을 1로 초기화하고, 큐에서 A B 값이 나오면 lectures[A]의 값을 lectures[B]에 더해준다.
    // 그러면 선수과목이 가지는 선수과목의 개수+1학기이므로 한 과목이 몇 학기 만에 끝나는지 알 수 있다.
    // => 틀린 풀이다.
    // https://kwoncorin.tistory.com/75
    //1) 다이내믹 프로그래밍
    //X번 과목이 이수할 수 있는 최소 학기를 dp [X]라 할 때 dp [X]는 X의 선수과목들의 최소 학기의 최댓값 +1이다.
    //dp [X]=MAX(dp [Y]+1) (Y는 X의 선수과목)
    //점화식과 선수과목 조건 A B가 주어질 때 A <B라는 점을 이용하여 ( 선수과목 조건이 A> B인 경우가 없기에 1번부터 순서대로 점화식을 구할 수 있다.)
    //1번 과목부터 N번 과목까지 최소 학기를 구한다.
    //2) 위상 정렬
    //진입 차수가 0인 것을 queue에 먼저 넣고 queue에서 값(now)을 꺼내 현재 pre (순서 과목 최소 학기)의 값을 저장한 후 (dp [now]=pre), now 과목을 선수과목으로 둔 과목 중에서 진입 차수가 0인 것은 queue에 저장한다.
    //위상 정렬의 경우 진행 중 진입 차수가 0인 정점이 없다면 위상 정렬 알고리즘을 사용할 수 없는데 이 문제의 경우 선수 과목 조건 A B가 주어질 때 A <B라는 조건이 있기에 위상 정렬을 사용할 수 있다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int N = Integer.parseInt(nums[0]);
        int M = Integer.parseInt(nums[1]);


        int[] dp = new int[N+1];
        boolean[][] list = new boolean[N+1][N+1];
        Arrays.fill(dp, 1);

        //  A과목 B과목 순서가 q에 저장된다.
        for(int i = 0 ; i < M ; i++) {
            String[] temp = br.readLine().split(" ");
            list[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = true;
        }

        for(int i = 1 ; i <= N ; i++) {
            dp[i] = 1;
            for(int j = 1 ; j <= N ; j++) {
                if(list[j][i]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }



        for(int i = 1 ; i < N+1 ; i++) {
            bw.write(dp[i]+" ");
        }




        br.close();
        bw.flush();
        bw.close();
    }
}

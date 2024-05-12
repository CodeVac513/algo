package binary_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class p17951 {
    //1. 입력 생각하기
    //첫 번째 줄에 시험지의 개수 N과 시험지를 나눌 그룹 수 K가 정수로 주어진다.
    //(1 <= K <= N <= 10^5)
    //두 번째 줄에 시험지 마다 맞은 문제의 개수 x가 정수로 주어진다. (0<=x<=20)
    //2. 구현 생각하기
    //이진 탐색으로 푸는 문제였다!!!!
    //각 그룹의 합의 최솟값을 바이너리 서치로 탐색한다.
    //최초의 upperBound와 lowerBound는 각각 모든 x의 합과 0으로 설정된다.
    //midValue는 (x+0) / 2 로 초기 설정이 된다.
    //그래서 lowerBound와 upperBound가 같은 값을 가질 때까지 반복한다.
    //currentSum은 그룹별로 맞은 문제 개수를 저장하고 groupCount는 currentSum이 midValue 이상을 만족할 때
    //1씩 늘어나고 currentSum은 0으로 초기화된다.( 조건을 만족하면 group으로 인정받는다)
    //groupCount가 K보다 크거나 같은 경우에는 그룹별로 맞은 문제 개수 중 최솟값이 현재보다 커야 한다.
    //(그룹의 개수를 줄여야 하기 때문!)
    // => lowerBound와 값을 mid + 1로 갱신한다.
    //groupCount가 K보다 작거나 같은 경우에는 그룹별로 맞은 문제 개수 중 최솟값이 현재보다 작아야 한다.
    //(그룹의 개수를 늘려야 하기 때문!)
    // => upperBound 값을 mid - 1로 갱신한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temps = br.readLine().split(" ");

        int N = Integer.parseInt(temps[0]);
        int K = Integer.parseInt(temps[1]);

        String[] nums = br.readLine().split(" ");

        int[] x = new int[N];
        int sum = 0;
        for(int i = 0 ; i < N ; i++) {
            x[i] = Integer.parseInt(nums[i]);
            sum += Integer.parseInt(nums[i]);
        }

        int lowerBound = 0;
        int upperBound = sum;

        while(lowerBound <= upperBound) {
            int midValue = (lowerBound + upperBound) / 2;

            int currentSum = 0;
            int groupCount = 0;
            for(int i = 0 ; i < N ; i++) {
                currentSum += x[i];
                if(currentSum >= midValue) {
                    groupCount++;
                    currentSum = 0;
                }
            }
            if(groupCount >= K) {
                lowerBound = midValue + 1;
            } else {
                upperBound = midValue - 1;
            }
        }

        bw.write(upperBound+"\n");

        br.close();
        bw.flush();
        bw.close();
    }
}

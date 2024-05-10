package sort;

import java.io.*;

public class p2750 {
    //1. 입력 생각하기
    // N개의 정수가 입력된다, (1<= N <= 1000)
    //2. 구현 생각하기
    //그냥 버블 정렬로 풀어보자.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] intArr = new int[N];

        for(int i = 0 ; i < N ; i++) {
            intArr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0 ; i < N - 1 ;i++) {
            //N-1번만큼 돌면서 반복한다.
            for(int j = 0 ; j < N - (i+1) ; j++) {
                //1번째는 i=0이므로, 처음부터 끝까지 검사해서 가장 큰 값을 j < N - (0 + 1)이므로
                // j = N - (0 + 1) - 1, j = N - 2라는 값을 가질 때 intArr[N-1]에 박아놓는다.
                //제일 큰 값을 찾았으니 i의 2번째 루프인 i=1인 경우에는 j < N - (1+1)만큼의 범위까지
                //탐색하므로 j = N - 2 - 1인 값을 가질때 ,intArr[N-2]에 다음으로 가장 큰 값을 박는다.
                //그렇게 j가 0일때만 루프를 돌때까지 반복하고 정렬을 완료한다.
                if(intArr[j] > intArr[j+1]) {
                    int temp = intArr[j+1];
                    intArr[j+1] = intArr[j];
                    intArr[j] = temp;
                }
            }

        }

        for(int i = 0 ; i < N ; i++) {
            bw.write(intArr[i]+"\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }
}

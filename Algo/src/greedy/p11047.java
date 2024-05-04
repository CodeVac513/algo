package greedy;

import java.io.*;

public class p11047 {
    //1. 구현 생각하기
    // 동전은 N가지 종류, 개수는 무한하다고 가정.
    // 동전들의 가치의 합을 잘 조절해서 K로 만들고 이 때 갯수를 최솟값으로 출력하는 것이 문제
    // k값이 1부터 10^8까지 가질 수 있다, N값은 1부터 10까지 가질 수 있다.
    // 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000), A1은 항상 1이고 i ≥ 2인 경우에 Ai는 Ai-1의 배수
    // ----------------------------------------------------
    // K값에서 동전의 가치가 제일 큰 값을 계속 빼준다.
    // 어느 순간에는 값을 빼면 음수가 나올 것인데 그 때는 그것보다 한 단계 아래의 큰 값을 빼준다.
    // 음수가 나온다면 다시 한 단계 아래, 음수가 아니라면 음수가 되기 직전까지 계속 빼나간다.
    // 위의 과정이 반복되면 문제가 해결될 것이다.
    // => 전형적인 greedy 문제로 최선의 방법을 반복하면 답이 도출된다.
    // **막간의 팁
    // 큰 수를 보면 항상 Integer 안에 다 담길 수 있는지 생각해야 함.
    // -> 꿀팁은 int형은 4바이트로 2,147,483,647까지 숫자를 저장할 수 있는데, 대충 10^9 정도로 생각하면 됨.
    // 정확한 숫자를 몰라도 자릿수가 10^9을 넘어가면 자료형을 바꾸어 주는 것이 좋다.


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        int N = Integer.parseInt(nums[0]);
        int K = Integer.parseInt(nums[1]);

        //동전의 가치를 저장할 배열 선언
        int[] price = new int[N];

        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }

        //동전의 갯수를 저장할 변수
        int ans = 0;
        // price 배열의 index, 초기값은 마지막인 N-1로 설정
        int largest = N - 1;


        //K가 0이 될 때까지 loop를 돌릴 것이고 1번 돌 때마다 동전이 1개씩 늘어나기에 ans에 +1
        while (K != 0) {


            if (K - price[largest] >= 0) {
                //동전 중 가장 가치가 큰 값을 뺐을 때 0보다 크면 K에서 그 값을 빼고 ans에 +1
                K = K - price[largest];
                ans++;
            } else {
                //만약 음수가 되어버리면 다음 단계로 가야하기에 largest - 1;
                largest--;
            }
        }


        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}


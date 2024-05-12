package binary_search;

import java.io.*;
import java.util.Arrays;

public class p3649 {
    // 1. 입력 생각하기
    // 테스트 케이스의 개수를 알려주지 않으므로 무한 반복하다가
    // EOF ( end of file)이 발생해서 더 이상 데이터가 없으면 반복을 멈춘다.
    // 2. 구현 생각하기
    // 예상한대로 바이너리 서치에서 파생된 문제이다.
    // array를 정렬해서 양 끝쪽에서부터 찾으면 두 개의 차의 절댓값이 가장 큰 값을 찾을 수 있다.
    // 두 개의 합이 목표보다 크면 upperBound를 1칸 내리면 되고 작으면 lowerBound를 1칸 올리면 된다.
    // 이 문제 input에서 br.readLine() 이걸로 검사하니까 반복문 내부에서 bw를 쓰면 뭔가 문제가 생김.
    // 버퍼를 공유하나? 그래서 sout으로 고쳐서 풀어야할 듯.
    // 아니면 arrayList에 담아놓고 나중에 종료시킬 때 출력하던가.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = null;
        while((input=br.readLine()) != null) {
            //나노 센티미터 기준이므로 10^7을 곱해준다
            int x = Integer.parseInt(input) * 10000000;
            int n = Integer.parseInt(br.readLine());
            int[] l = new int[n];

            for(int i = 0 ; i < n ; i++) {
                l[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(l);

            int lowerBound = 0;
            int upperBound = n - 1;
            boolean danger = false;

            while(lowerBound<upperBound) {
                int sum = l[lowerBound] + l[upperBound];

                if(sum == x) {
                    System.out.println("yes "+l[lowerBound]+" "+l[upperBound]);
                    danger = true;
                    break;
                } else if (sum > x){
                    upperBound--;
                } else {
                    lowerBound++;
                }
            }

            if(!danger) {
                System.out.println("danger");
            }
            input=null;
            danger=false;
        }

        bw.flush();
        bw.close();
        br.close();
    }

}

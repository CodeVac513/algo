package other_platform;

import java.io.*;
import java.util.*;

public class p5658_sw {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1 ; test_case <= T ; test_case++) {

            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int K = Integer.parseInt(temp[1]);
            TreeSet<String> pool = new TreeSet<>(Collections.reverseOrder());
            String[] nums = br.readLine().split("");

            int iter = N / 4;
            for(int i = 0 ; i < iter ; i++) {
                //회전 시켜주는 과정.
                String lastNum = nums[N-1];
                for(int j = N-1;  j > 0 ; j--) {
                    nums[j] = nums[j-1];
                }
                nums[0] = lastNum;
                for(int j = 0 ; j < N ; j+= N/4) {
                    StringBuilder sb = new StringBuilder();
                    for(int k = j ; k < j + (N/4) ; k++) {
                        sb.append(nums[k]);
                    }
                    pool.add(sb.toString());
                }
            }
            String[] ans = pool.toArray(new String[pool.size()]);
            bw.write("#"+test_case+" "+Long.parseLong(ans[K-1],16)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class p11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> p = new ArrayList<>();
        String[] nums = br.readLine().split(" ");

        int ans;
        for(ans = 0; ans < N; ++ans) {
            p.add(Integer.parseInt(nums[ans]));
        }

        Collections.sort(p);
        ans = 0;

        for(int i = 0; i < N; ++i) {
            for(int j = i; j >= 0; --j) {
                ans += (Integer)p.get(j);
            }
        }

        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}

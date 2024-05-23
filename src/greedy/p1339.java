package greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class p1339 {
    //답은 Integer의 범위 안에 들어온다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] numStr = new String[N];
        Integer[] alphabets = new Integer[26];
        Arrays.fill(alphabets,0);

        for(int i = 0 ; i < N ; i++) {
            numStr[i] = br.readLine();

            for(int j = 0 ; j < numStr[i].length() ; j++) {
                int index = numStr[i].charAt(j)-'A';
                alphabets[index] += (int) Math.pow((double) 10, (double)(numStr[i].length()- (j + 1)));

            }
        }

        Arrays.sort(alphabets, Collections.reverseOrder());

        int ans = 0;
        int weight = 9;

        for(int i : alphabets) {
            if(i == 0)
                break;
            ans += weight * i;
            weight--;
        }

        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

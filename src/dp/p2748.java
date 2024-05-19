package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2748 {
    public p2748() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = (long)Integer.parseInt(br.readLine());
        long a = 0L;
        long b = 1L;

        for(int i = 2; (long)i <= n; ++i) {
            long temp = a + b;
            a = b;
            b = temp;
        }

        bw.write("" + b + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}

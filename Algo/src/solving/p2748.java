package solving;

import java.io.*;

public class p2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Integer.parseInt(br.readLine());
        long a = 0;
        long b = 1;
        for(int i = 2 ; i <= n ; i++) {
            long temp = a+b;
            a = b;
            b = temp;
        }
        bw.write(b+"\n");
        br.close();
        bw.flush();
        bw.close();
    }
}

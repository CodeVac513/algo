package data_structure;

import java.io.*;
import java.util.HashMap;

public class p17219 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        HashMap<String,String> password = new HashMap<>();
        for(int testCase = 0 ; testCase < N ; testCase++) {
            String[] pwTemp = br.readLine().split(" ");
            password.put(pwTemp[0], pwTemp[1]);
        }

        for(int i = 0 ; i < M ; i++) {
            String target = br.readLine();
            bw.write(password.get(target)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

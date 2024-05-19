package binary_search;

import java.io.*;
import java.util.Arrays;

public class p3649 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = null;

        while((input = br.readLine()) != null) {
            int x = Integer.parseInt(input) * 10000000;
            int n = Integer.parseInt(br.readLine());
            int[] l = new int[n];

            for (int i = 0 ; i < n ; i++) {
                l[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(l);

            int upperBound = n - 1;
            int lowerBound = 0;
            boolean flag = false;

            while(lowerBound < upperBound) {
                int middle = (l[upperBound] + l[lowerBound]);

                if(middle == x) {
                    flag = true;
                    System.out.println("yes "+l[lowerBound]+" "+l[upperBound]);
                    break;
                } else if (middle > x) {
                    upperBound--;
                } else {
                    lowerBound++;
                }

            }

            if(!flag) {
                System.out.println("danger");
            }
            input = null;

        }


        br.close();
        bw.flush();
        bw.close();
    }
}






















//
//        import java.io.BufferedReader;
//        import java.io.BufferedWriter;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.io.OutputStreamWriter;
//        import java.util.Arrays;
//
//public class p3649 {
//    public p3649() {
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        boolean danger;
//        for(String input = null; (input = br.readLine()) != null; danger = false) {
//            int x = Integer.parseInt(input) * 10000000;
//            int n = Integer.parseInt(br.readLine());
//            int[] l = new int[n];
//
//            int lowerBound;
//            for(lowerBound = 0; lowerBound < n; ++lowerBound) {
//                l[lowerBound] = Integer.parseInt(br.readLine());
//            }
//
//            Arrays.sort(l);
//            lowerBound = 0;
//            int upperBound = n - 1;
//            danger = false;
//
//            while(lowerBound < upperBound) {
//                int sum = l[lowerBound] + l[upperBound];
//                if (sum == x) {
//                    System.out.println("yes " + l[lowerBound] + " " + l[upperBound]);
//                    danger = true;
//                    break;
//                }
//
//                if (sum > x) {
//                    --upperBound;
//                } else {
//                    ++lowerBound;
//                }
//            }
//
//            if (!danger) {
//                System.out.println("danger");
//            }
//
//            input = null;
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}

package binary_search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p17951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);

        String[] numStr = br.readLine().split(" ");
        int[] nums = new int[N];
        int sum = 0;
        for(int i = 0 ; i < N ; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
            sum += nums[i];
        }

        int upperBound = sum;
        int lowerBound = 0;

        while(lowerBound <= upperBound) {
            int middle = (upperBound + lowerBound) / 2;
            int count = 0;
            int currentSum = 0;
            for(int i = 0 ; i < N ; i++) {
                currentSum += nums[i];
                if (middle <= currentSum) {
                    count++;
                    currentSum = 0;
                }
            }

            if(count >= K) {
                lowerBound = middle + 1;
            } else{
                upperBound = middle - 1;
            }
        }

        bw.write(upperBound+"\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
























//
//package binary_search;
//
//        import java.io.BufferedReader;
//        import java.io.BufferedWriter;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.io.OutputStreamWriter;
//
//public class p17951 {
//    public p17951() {
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] temps = br.readLine().split(" ");
//        int N = Integer.parseInt(temps[0]);
//        int K = Integer.parseInt(temps[1]);
//        String[] nums = br.readLine().split(" ");
//        int[] x = new int[N];
//        int sum = 0;
//
//        int lowerBound;
//        for(lowerBound = 0; lowerBound < N; ++lowerBound) {
//            x[lowerBound] = Integer.parseInt(nums[lowerBound]);
//            sum += Integer.parseInt(nums[lowerBound]);
//        }
//
//        lowerBound = 0;
//        int upperBound = sum;
//
//        while(lowerBound <= upperBound) {
//            int midValue = (lowerBound + upperBound) / 2;
//            int currentSum = 0;
//            int groupCount = 0;
//
//            for(int i = 0; i < N; ++i) {
//                currentSum += x[i];
//                if (currentSum >= midValue) {
//                    ++groupCount;
//                    currentSum = 0;
//                }
//            }
//
//            if (groupCount >= K) {
//                lowerBound = midValue + 1;
//            } else {
//                upperBound = midValue - 1;
//            }
//        }
//
//        bw.write("" + upperBound + "\n");
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//}

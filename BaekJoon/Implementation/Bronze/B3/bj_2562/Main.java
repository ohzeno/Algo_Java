package BaekJoon.Implementation.Bronze.B3.bj_2562;// https://www.acmicpc.net/problem/2562

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*

 */

public class Main {
    static String INPUT = "input.txt";
    static BufferedReader br;
//    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader(INPUT));
//        br = new BufferedReader(new InputStreamReader(System.in));
        int maxVal = 0;
        int maxIdx = 0;
        for (int i = 1; i <= 9; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val > maxVal) {
                maxVal = val;
                maxIdx = i;
            }
        }
        System.out.println(maxVal);
        System.out.println(maxIdx);
    }
}


/*
현 시점 Bronze III. 제출 346770. 정답률 45.438 %
*/
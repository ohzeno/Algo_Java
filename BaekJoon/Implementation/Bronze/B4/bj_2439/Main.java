package BaekJoon.Implementation.Bronze.B4.bj_2439;// https://www.acmicpc.net/problem/2439

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*

 */

public class Main {
    static String INPUT = "input.txt";
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader(INPUT));
//        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            System.out.println(" ".repeat(n - i) + "*".repeat(i));
        }
    }
}


/*
현 시점 Bronze IV. 제출 348569. 정답률 56.002 %
*/
package BaekJoon.Implementation.Bronze.B5.bj_2475;// https://www.acmicpc.net/problem/2475

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*

 */

public class Main {
    static String INPUT = "input.txt";
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader(INPUT));
//        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        double acc = 0;
        for (int i = 1; i <= 5; i++) {
            acc += Math.pow(Integer.parseInt(st.nextToken()), 2);
        }
        System.out.println((int) acc % 10);
    }
}


/*
현 시점 Bronze V. 제출 77474. 정답률 74.633 %
*/
package BaekJoon.String.Bronze.B2.bj_1152;// https://www.acmicpc.net/problem/1152

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
        String line = br.readLine().trim();
        if (line.isEmpty()) {  // 공백 하나만 들어오는 경우 대비
            System.out.println(0);
        } else {
            System.out.println(line.split(" ").length);
        }
    }
}


/*
현 시점 Bronze II. 제출 416795. 정답률 33.181 %
*/
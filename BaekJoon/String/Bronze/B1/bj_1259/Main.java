package BaekJoon.String.Bronze.B1.bj_1259;// https://www.acmicpc.net/problem/1259

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*

 */

public class Main {
    static String INPUT = "input.txt";
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader(INPUT));
//        br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals("0")) break;
            boolean isPalindrome = isPalindrome(line);
            System.out.println(isPalindrome ? "yes" : "no");
        }
    }

    private static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

/*
현 시점 Bronze I. 제출 72325. 정답률 56.841 %
*/

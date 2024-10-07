package BaekJoon.Math.Bronze.B2.bj_1978;// https://www.acmicpc.net/problem/1978

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/*

 */

public class Main {
    static String INPUT = "input.txt";
    static BufferedReader br;
//    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader(INPUT));
//        br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int cnt = 0;
        for (int num : numbers) {
            if (isPrime(num)) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean isPrime(int num) {
        if (num == 1) return false;
        if (num == 2) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}


/*
현 시점 Bronze II. 제출 223478. 정답률 47.287 %
*/
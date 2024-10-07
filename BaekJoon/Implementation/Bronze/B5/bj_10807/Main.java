package BaekJoon.Implementation.Bronze.B5.bj_10807;// https://www.acmicpc.net/problem/10807

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
        int n = Integer.parseInt(br.readLine());
        List<String> numbers = Arrays.asList(br.readLine().split(" "));
        String v = br.readLine();
        int count = Collections.frequency(numbers, v);
        System.out.println(count);
    }
}


/*
현 시점 Bronze V. 제출 148094. 정답률 62.024 %
*/
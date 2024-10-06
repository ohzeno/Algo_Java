package BaekJoon.Math.Bronze.B3.bj_4153;// https://www.acmicpc.net/problem/4153

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
        while (true) {
            int[] numbers = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (numbers[0] == 0) break;
            Arrays.sort(numbers);
            int a = numbers[0], b = numbers[1], c = numbers[2];
            boolean isRight = a * a + b * b == c * c;
            System.out.println(isRight ? "right" : "wrong");
        }
    }
}


/*
현 시점 Bronze III. 제출 102086. 정답률 50.521 %
*/
// https://www.acmicpc.net/problem/2438

import java.io.*;
import java.util.*;

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
            System.out.println("*".repeat(i));
        }
    }
}


/*
현 시점 Bronze V. 제출 352224. 정답률 62.171 %
*/
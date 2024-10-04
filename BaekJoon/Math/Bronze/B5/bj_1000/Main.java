// https://www.acmicpc.net/problem/1000

import java.io.*;
import java.util.*;

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

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(a + b);
    }
}


/*
현 시점 Bronze V. 제출 1161339. 정답률 38.813 %
*/
package BaekJoon.BruteForce.Silver.S4.bj_1018;// https://www.acmicpc.net/problem/1018

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

 */


public class Main {
//    static String INPUT = "input.txt";
    static BufferedReader br;
    static StringTokenizer st;
    static final char[] DEFAULT_COLORS = {'W', 'B'};
    static final int BOARD_SIZE = 8;

    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new FileReader(INPUT));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            mat[i] = br.readLine().toCharArray();
        }

        int answer = n * m;
        for (int i = 0; i <= n - BOARD_SIZE; i++) {
            for (int j = 0; j <= m - BOARD_SIZE; j++) {
                answer = Math.min(answer, getMinChange(mat, i, j));
            }
        }
        System.out.println(answer);
    }

    private static int getMinChange(char[][] mat, int stRow, int stCol) {
        int[] change = new int[2];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                char expectedColor = DEFAULT_COLORS[(i + j) % 2];
                if (mat[stRow + i][stCol + j] != expectedColor) {
                    change[0]++;
                } else {
                    change[1]++;
                }
            }
        }
        return Math.min(change[0], change[1]);
    }
}


/*
현 시점 Silver IV. 제출 133194. 정답률 49.968 %
*/

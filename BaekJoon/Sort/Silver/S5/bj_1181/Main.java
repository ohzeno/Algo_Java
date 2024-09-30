package BaekJoon.Sort.Silver.S5.bj_1181;// https://www.acmicpc.net/problem/1181

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

 */


public class Main {
//    static String INPUT = "input.txt";
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new FileReader(INPUT));
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> uniqueWords = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueWords.add(br.readLine());
        }

        List<String> sortedWords = new ArrayList<>(uniqueWords);
        sortedWords.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }
            return s1.compareTo(s2);
        });

        for (String word : sortedWords) {
            System.out.println(word);
        }
    }
}


/*
현 시점 Silver V. 제출 202477. 정답률 40.465 %
*/

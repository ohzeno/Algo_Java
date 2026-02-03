package Programmers.NonCompany.Lv2;// https://school.programmers.co.kr/learn/courses/30/lessons/12951?language=java

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
constraints:

*/

class Solution {
    public String solution(String s) {
        String[] ss = s.split(" ", -1);
        ArrayList<String> res = new ArrayList<>();
        for (String word : ss) {
            if (word.length() == 0) {
                res.add(word);
                continue;
            }
            word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            res.add(word);
        }
        return String.join(" ", res);
    }
}

/*
연습문제
Lv.2. 현 시점 완료한 사람 44,487명, 정답률 80%
java에선 limit 0이 기본값이고 끝 공백을 제거하는거라 -1로 마지막 빈 문자열을 유지하게 해야 함.
*/

public class Main {
    public static void main(String[] args) {
        List<Map<String, Object>> inputdatas = List.of(
                Map.of("data", List.of("3people unFollowed me"), "answer", "3people Unfollowed Me"),
                Map.of("data", List.of("for the last week"), "answer", "For The Last Week")
        );

        Solution solution = new Solution();

        for (Map<String, Object> inputdata : inputdatas) {
            Object data = inputdata.get("data");
            Object ans = inputdata.get("answer");

            String dataResult = ((List<String>) data).get(0);

            Object res = solution.solution(dataResult);

            if (res.equals(ans)) {
                System.out.println("pass");
            } else {
                String summary = "fail";
                summary += "\n  expected:\n";
                summary += "    " + ans;
                summary += "\n  got:\n";
                summary += "    " + res;
                System.out.println(summary);
            }
        }
    }
}

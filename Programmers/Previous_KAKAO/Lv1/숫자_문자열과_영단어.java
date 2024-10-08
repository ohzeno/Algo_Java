package Programmers.Previous_KAKAO.Lv1;
// https://school.programmers.co.kr/learn/courses/30/lessons/81301

import java.util.List;
import java.util.Map;

/*
constraints:
  • 1 ≤ s의 길이 ≤ 50
  • s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
  • return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.
*/

class Solution {
    public int solution(String s) {
        Map<String, Integer> map = Map.of(
                "zero", 0,
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4,
                "five", 5,
                "six", 6,
                "seven", 7,
                "eight", 8,
                "nine", 9
        );
        StringBuilder newS = new StringBuilder();
        String tmp = "";
        for (char c: s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                newS.append(c);
            } else {
                tmp += c;
                if (map.containsKey(tmp)) {
                    newS.append(map.get(tmp));
                    tmp = "";
                }
            }
        }
        return Integer.parseInt(newS.toString());
    }
}

/*
2021 카카오 채용연계형 인턴십
Lv.1. 현 시점 완료한 사람 50,835명, 정답률 72%
*/

public class 숫자_문자열과_영단어 {
    public static void main(String[] args) {
        List<Map<String, Object>> inputdatas = List.of(
                Map.of("data", "one4seveneight", "answer", 1478),
                Map.of("data", "23four5six7", "answer", 234567),
                Map.of("data", "2three45sixseven", "answer", 234567),
                Map.of("data", "123", "answer", 123)
        );

        Solution solution = new Solution();

        for (Map<String, Object> inputdata : inputdatas) {
            Object data = inputdata.get("data");
            Object ans = inputdata.get("answer");

            Object res = solution.solution((String) data);

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


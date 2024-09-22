// https://school.programmers.co.kr/learn/courses/30/lessons/17682

import java.util.List;
import java.util.Map;

/*
constraints:
  • 0 ≤ num1 ≤ 10,000
  • 0 ≤ num2 ≤ 10,000
*/

class Solution {
    public static Object solution(List<Object> data) {
        return null;  // 실제 구현 로직이 여기에 들어갑니다.
    }
}

/*
2022 카카오 테크 인턴십 기출.
Lv.3. 현 시점 완료한 사람 1155명, 정답률 22%
*/

public class Main {
    public static void main(String[] args) {
        List<Map<String, Object>> inputdatas = List.of(
                Map.of("data", List.of(), "answer", "")
        );

        Solution solution = new Solution();

        for (Map<String, Object> inputdata : inputdatas) {
            Object data = inputdata.get("data");
            Object ans = inputdata.get("answer");

            Object res = solution.solution((List<Object>) data);

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


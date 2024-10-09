package Programmers.Previous_KAKAO.Lv1;// https://school.programmers.co.kr/learn/courses/30/lessons/17682?language=java

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*
constraints:

*/

class Solution {
    public int solution(String dartResult) {
        Map<Character, Integer> bonus2exp = Map.of('S', 1, 'D', 2, 'T', 3);
        int[] points = new int[3];
        int curPoint = 0;
        int idx = 0;
        for (char c : dartResult.toCharArray()) {
            if (Character.isDigit(c)) {
                curPoint = curPoint * 10 + Character.getNumericValue(c);
            } else if (bonus2exp.containsKey(c)) {
                points[idx++] = (int) Math.pow(curPoint, bonus2exp.get(c));
                curPoint = 0;
            } else if (c == '*') {
                if (idx >= 2) points[idx - 2] *= 2;
                points[idx - 1] *= 2;
            } else if (c == '#') {
                points[idx - 1] *= -1;
            }
        }
        return Arrays.stream(points).sum();
    }
}

/*
2018 KAKAO BLIND RECRUITMENT
Lv.1. 현 시점 완료한 사람 28,567명, 정답률 59%
if (idx >= 2) points[idx-2] *= 2;
points[idx-1] *= 2;
이 부분 js는 splice, 파이썬은 [-2:]로 처리했지만
자바는 그런 편리한 기능이 없어서 if문을 사용할 수 밖에 없었다.
ArrayList를 사용하면 subList로 if문 없이 처리할 수 있지만,
그렇게 하면 인덱싱 대신 get, set, size 사용하면서 가독성이 떨어진다.
Map.of도 key, value를 명확히 알아보기 힘들어서 가독성이 떨어지는데
자바가 이건 개선 안하나 의문이다.
좀 깔끔한 다른 풀이 있나 다른 풀이들을 찾아봤는데,
엄청나게 길고 가독성 떨어지는 코드들밖에 없다.
*/

public class 일차_다트_게임 {
    public static void main(String[] args) {
        List<Map<String, Object>> inputdatas = List.of(
                Map.of("data", List.of("1S2D*3T"), "answer", 37),
                Map.of("data", List.of("1D2S#10S"), "answer", 9),
                Map.of("data", List.of("1D2S0T"), "answer", 3),
                Map.of("data", List.of("1S*2T*3S"), "answer", 23),
                Map.of("data", List.of("1D#2S*3S"), "answer", 5),
                Map.of("data", List.of("1T2D3D#"), "answer", -4),
                Map.of("data", List.of("1D2S3T*"), "answer", 59)
        );

        Solution solution = new Solution();

        for (Map<String, Object> inputdata : inputdatas) {
            Object data = inputdata.get("data");
            Object ans = inputdata.get("answer");

            String dartResult = ((List<String>) data).get(0);

            Object res = solution.solution(dartResult);

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

package Programmers.Previous_KAKAO.Lv2;// https://school.programmers.co.kr/learn/courses/30/lessons/17680?language=java

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
constraints:

*/

class Solution {
    public int solution(int cacheSize, String[] cities) {
        final int HIT = 1;
        final int MISS = 5;
        if (cacheSize == 0) return cities.length * MISS;
        int time = 0;
        /*
        initialCapacity: 초기 용량
        loadFactor: 리사이징 임계값. 0.75f가 기본값. 75%가 차면 리사이징
        accessOrder: true면 접근 순서(최신이 뒤)대로 정렬. false면 삽입 순서대로 정렬
        removeEldestEntry: 기본적으로는 항상 false. 요소 추가 때마다 호출되어 true면 가장 오래된 요소를 제거
        */
        LinkedHashMap<String, Object> cache = new LinkedHashMap<String, Object>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
                return size() > cacheSize;
            }
        };
        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.containsKey(city)) {
                time += HIT;
            } else {
                time += MISS;
            }
            cache.put(city, null);
        }
        return time;
    }
}

/*
2018 KAKAO BLIND RECRUITMENT
Lv.2. 현 시점 완료한 사람 20,442명, 정답률 64%
LinkedHashMap 덕분에 편하게 풀긴 했다.
LinkedHashMap 자체의 사용법을 익히는 것에 시간을 썼다.
ArrayList로 풀까 하다가 python, js는 OrderedDict, Map을 사용했는데
자바만 ArrayList로 푸는 것도 좀 이상해서 LinkedHashMap을 사용했다.
*/

public class 일차_캐시 {
    public static void main(String[] args) {
        List<Map<String, Object>> inputdatas = List.of(
                Map.of("data", List.of(3, new Object[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}), "answer", 50),
                Map.of("data", List.of(3, new Object[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}), "answer", 21),
                Map.of("data", List.of(2, new Object[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}), "answer", 60),
                Map.of("data", List.of(5, new Object[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}), "answer", 52),
                Map.of("data", List.of(2, new Object[]{"Jeju", "Pangyo", "NewYork", "newyork"}), "answer", 16),
                Map.of("data", List.of(0, new Object[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}), "answer", 25)
        );

        Solution solution = new Solution();

        for (Map<String, Object> inputdata : inputdatas) {
            Object data = inputdata.get("data");
            Object ans = inputdata.get("answer");

            int cacheSize = (int) ((List<Object>) data).get(0);
            Object[] citiesObj = (Object[]) ((List<Object>) data).get(1);
            String[] cities = Arrays.stream(citiesObj)
                    .map(Object::toString)
                    .toArray(String[]::new);

            Object res = solution.solution(cacheSize, cities);

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

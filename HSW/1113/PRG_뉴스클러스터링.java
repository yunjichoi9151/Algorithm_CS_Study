package Baekjoon.Programmers;

/*
    자카드 유사도 = 교집합 / 합집합
    문자열의 대소는 구별안함
    2글자씩 끊어서 교집합 합집합 만들기
 */


import java.util.HashMap;

public class PRG_뉴스클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;
        double in = 0.0;  //intersection : 교집합
        double un = 0.0;  //union : 합집합

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        HashMap<String, Integer> str1Map = new HashMap<>();
        HashMap<String, Integer> str2Map = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i, i + 2).replaceAll("[^a-z]", "");   //a~z이외는 전부 지움
            if (str.length() != 2)  //+같은 기호가 섞여서 문자크기가 2가 아닐경우
                continue;
            str1Map.put(str, str1Map.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String str = str2.substring(i, i + 2).replaceAll("[^a-z]", "");   //a~z이외는 전부 지움
            if (str.length() != 2)  //+같은 기호가 섞여서 문자크기가 2가 아닐경우
                continue;
            str2Map.put(str, str2Map.getOrDefault(str, 0) + 1);
        }

        for (String key : str1Map.keySet()) {
            if (str2Map.containsKey(key)) {
                in += Math.min(str1Map.get(key), str2Map.get(key)); //교집합
                un += Math.max(str1Map.get(key), str2Map.get(key)); //합집합
                str2Map.remove(key);    //중복되는 키이므로 삭제
            } else
                un += str1Map.get(key); //str1에만 있는 키이므로 합집합에 추가
        }

        //str2에만 있는 키
        for (String key : str2Map.keySet())
            un += str2Map.get(key);

        answer = (int) Math.floor((in / un) * 65536);

        //예외케이스
        if (str1Map.size() == 0 && str2Map.size() == 0)
            answer = 65536;

        return answer;
    }
}

package Baekjoon.Programmers;

/*
    n개의 숫자들 간에 차이가 작을 수록 최고의 집합
 */

public class PRG_최고의집합 {
    public int[] solution(int n, int s) {
        int[] answer = {};

        int q = s / n;  //몫
        int r = s % n;  //나머지

        if (q == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        } else {
            answer = new int[n];
        }

        for (int i = 0; i < n; i++) {
            if (r > 0 && i >= n - r) {
                answer[i] = q + 1;
            } else
                answer[i] = q;
        }


        return answer;
    }
}

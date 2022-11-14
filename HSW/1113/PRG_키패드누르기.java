package Baekjoon.Programmers;

public class PRG_키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                answer += "L";      //왼손으로 누름
                left = num;         //왼손 이동
            } else if (num == 3 || num == 6 || num == 9) {
                answer += "R";
                right = num;
            } else {
                //0번을 10번(*)과 12번(#) 사이 11번으로 취급
                if (num == 0) {
                    num = 11;
                }

                //키패드로부터 각 손까지의 거리 구하기
                int left_dist = (Math.abs(num - left)) / 3 + (Math.abs(num - left)) % 3;
                int right_dist = (Math.abs(num - right)) / 3 + (Math.abs(num - right)) % 3;

                //오른손이 더 멀 경우
                if (left_dist < right_dist) {
                    answer += "L";
                    left = num;
                }
                //왼손이 더 멀 경우
                else if (left_dist > right_dist) {
                    answer += "R";
                    right = num;
                }
                //두 손이 거리가 같으면 어느 손잡이인지 확인
                else {
                    //오른손 잡이
                    if (hand.equals("right")) {
                        answer += "R";
                        right = num;
                    } else {
                        answer += "L";
                        left = num;
                    }
                }
            }
        }

        return answer;
    }
}

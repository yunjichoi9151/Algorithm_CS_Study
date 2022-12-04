package prg.lv1;

import java.util.Arrays;

public class PRG_비밀지도 {

    static public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int val = arr1[i] | arr2[i]; // or 연산


            answer[i] = Integer.toBinaryString(val).replaceAll("1", "#").replaceAll("0", " ");
            int len = answer[i].length();

            if (len < n) { // 앞에 0 추가
                for (int j = 0; j < n - len; j++) {
                    answer[i] = " " + answer[i];
                }
            }

        }


        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(solution(n, arr1, arr2)));
    }
}

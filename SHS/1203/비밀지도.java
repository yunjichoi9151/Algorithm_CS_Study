package d221204;
//자바 내장함수 toBinaryString을 활용하면 매우 간단하게 풀리는 문제
//10진수를 2진수로 변환 가능
//16진수(toHexString​) 8진수(toOctalString) 도 있음

public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
        	//두 배열 원소를 이진수로 변환시키기 + or 연산으로  1인 경우 전부 칠하기
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            //문자열로 변환
            s = String.format("%" + n + "s", s);
            // 1-># 0->공백
            s = s.replace("1", "#");
            s = s.replace("0", " ");
            //한 줄씩 저장
            answer[i] = s;
        }

        return answer;
    }
}

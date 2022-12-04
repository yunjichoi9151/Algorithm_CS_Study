public class Secret_Map {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // answer : 답 담기 위한 배열
        String[] answer = new String[n];
        // arr3 : 원래 지도의 값 구하기 위한 배열
        int[] arr3 = new int[n];
        for(int i = 0; i < n; i++) {
            // 둘 중 하나라도 벽(1)이면 -> 전체 지도에서 벽
            // 둘 모두 공백(0)이면 -> 전체 지도에서 공백
            // OR로 원래 지도의 값 구함
            arr3[i] = arr1[i] | arr2[i];
        }
        for(int i = 0; i < n; i++) {
            // 10진수 -> 2진수로 변환
            String s = Integer.toBinaryString(arr3[i]);
            // n보다 길이가 작다는 것은, 앞쪽에 0을 더 붙여줘야 하는 case인 것임
            // ex) 11110 -> 011110
            if(s.length() < n) {
                // 몇 개 더 붙여줘야하는지 구함
                int k = n - s.length();
                // 그만큼 반복
                for(int j = 0; j < k; j++) {
                    // s의 앞쪽에 0 붙임
                    s = "0" + s;
                }
            }
            // 1은 벽 표시인 '#'로 변환
            s = s.replaceAll("1", "#");
            // 0은 공백으로 변환
            s = s.replaceAll("0", " ");
            answer[i] = s;
        }
        return answer;
    }
}

import java.util.Arrays;

public class Number_Game {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int tmp = 0;
        // len : 배열 길이(A와 B 길이 같음)
        int len = A.length;
        // 큰 순서대로 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < len; i++) {
            for(int j = tmp; j < len; j++) {
                // A 값보다 B 값이 더 크다면
                if(A[i] < B[j]) {
                    // answer +1
                    answer++;
                    // 다음 원소부터 판별하게끔 tmp 업데이트
                    tmp = j + 1;
                    // 다음으로 넘어감
                    break;
                }
            }
        }
        return answer;
    }
}

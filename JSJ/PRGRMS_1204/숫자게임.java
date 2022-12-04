package PRGRMS_1204;

import java.util.Arrays;

public class 숫자게임 {
	public int solution(int[] A, int[] B) {
		int answer = 0;

		// B의 순서는 조작할 수 있기 때문에 A,B 모두 정렬한 상태에서 시작
		Arrays.sort(A);
		Arrays.sort(B);

		// index
		int idxA = 0;
		int idxB = 0;

		// index의 범위가 넘지 않는 동안
		while (idxA < A.length && idxB < B.length) {

			// A요소가 B의 요소보다 작을 때만 answer+1, A의 다음 요소로 넘어가서 비교
			if (A[idxA] < B[idxB]) {
				answer++;
				idxA++;
			}

			// 비교 후 B의 index+1 (B 승리, 무승부, 패배 일 때 모두 다음으로 넘어가야 함)
			idxB++;
		}
		return answer;
	}
}
package PRGRMS_1204;

// 숫자 암호화
// 1. 지도는 한 변의 길이가 n인 정사각형 배열 형태, "공백"(" ") / "벽"("#") 두 종류로 이루어져 있다.
// 2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
// 3. "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
// 4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.

// 풀이
// arr1, arr2 의 요소 2진수로 바꾸기
// 각 칸의 요소 비교해서 벽인부분, 공백인 부분 판별
// 배열로 출력

public class 비밀지도 {

	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		// 10진수 -> 2진수
		for (int i = 0; i < n; i++) {
			answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]); // 비트연산 (arr1[i], arr2[i] 중 하나라도 1이면 1)
		}

		for (int i = 0; i < n; i++) {
			answer[i] = String.format("%" + n + "s", answer[i]); // n자리수가 될 때까지 앞에 공백 포함

			// 1 -> # , 0 -> 공백 치환
			answer[i] = answer[i].replace("1", "#");
			answer[i] = answer[i].replace("0", " ");
		}

		return answer;
	}
}

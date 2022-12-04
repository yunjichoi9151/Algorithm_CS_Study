package prg.lv3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PRG_숫자게임 {
    public static void main(String[] args) {
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};
        System.out.println(solution(A, B));

    }

    static public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int bIdx = B.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            while (bIdx >= 0 && B[bIdx] > A[i]) {
                pq.add(B[bIdx]);
                bIdx--;
            }
            if (pq.size() > 0 && pq.peek() > A[i]) {
                pq.poll(); // A[i]보다 큰 원소 중에서 가장 작은 값 하나 빼기
                answer++;
            }
        }


        return answer;
    }
}

package 이공이삼삼월.d230309;
//coppyOfRange : 배열 특정 범위 복사
//(배열명, 시작인덱스, 배열크기)
import java.util.Arrays;

public class K번째수 {
	class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	        int[] answer = new int[commands.length];
	        
	        for(int i=0; i<commands.length; i++){
	            int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
	            Arrays.sort(tmp);
	            answer[i] = tmp[commands[i][2]-1];
	        }
	        
	        return answer;
	    }
	}
}

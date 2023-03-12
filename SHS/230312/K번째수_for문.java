package 이공이삼삼월.d230309;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K번째수_for문 {
	class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	    	 int[] answer = {};
			 answer = new int[commands.length];

			 for(int i =0; i<commands.length; i++) {
				 List<Integer> arrC = new ArrayList<Integer>();
				 for(int j = commands[i][0]-1; j<commands[i][1]; j++) {
					 arrC.add(array[j]);
				 }
				 Collections.sort(arrC);
				 answer[i] =arrC.get(commands[i][2]-1);
				
			 }
	        return answer;
	    }
	}
}

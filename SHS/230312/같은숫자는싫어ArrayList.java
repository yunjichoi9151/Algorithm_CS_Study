package 이공이삼삼월.d230309;

import java.util.ArrayList;

public class 같은숫자는싫어ArrayList {
	public class Solution {
	    public int[] solution(int []arr) {        
	        ArrayList<Integer> arr2 = new ArrayList<Integer>();
	        int tmp = -1;
	    for(int i=0; i<arr.length; i++){
	             if(arr[i] != tmp){
	                 arr2.add(arr[i]);
	                 tmp = arr[i];
	             }
	        }        
	        int[] answer = new int[arr2.size()];
	        for(int i=0; i<answer.length; i++){
	            answer[i] = arr2.get(i); 
	        }        
	        
	        return answer;
	    }
	}
}

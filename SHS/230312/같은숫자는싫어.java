package 이공이삼삼월.d230309;

import java.util.Stack;

public class 같은숫자는싫어 {
	public class Solution {
	    public int[] solution(int []arr) {        
	        Stack<Integer> stk = new Stack<>();
	        
	        for(int i=0; i<arr.length; i++){
	            if(stk.size()==0 || arr[i]!=stk.peek()){
	                stk.push(arr[i]);
	            }
	        }
	        
	        int[] answer = new int[stk.size()];

	        for(int i=stk.size()-1; i>=0; i--){
	            answer[i] = stk.pop();
	        }
	        
	        return answer;
	    }
	}
}

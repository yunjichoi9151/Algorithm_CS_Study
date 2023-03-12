package 이공이삼삼월.d230308;

import java.util.Arrays;

public class 체육복 {

	class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	    	
	    	//배열 정렬 안된 테케 있음
	        Arrays.sort(lost);
	        Arrays.sort(reserve);
	        
	        //전체 학생수에서 여전히 잃어버린 학생수 차감
	        int answer = n-lost.length;
	        
	        //여분 가져온 놈이 도난당한 테케 있음
	        for(int i=0; i<lost.length; i++){
	            for(int j=0; j<reserve.length; j++){
	                if(lost[i] == reserve[j]){
	                    answer++;
	                    //-1 처리해야 for문 안돌고 넘어감
	                    lost[i] = -1;
	                    reserve[j] = -1;
	                }
	            }
	        }        
	        
	        
	        //앞뒤에 빌려주고 ans ++ , -1 처리->둘 다  빌려줄 수는 없음
	        for(int i=0; i<lost.length; i++){
	            for(int j=0; j<reserve.length; j++){
	                if(lost[i]-1==reserve[j] || lost[i]+1==reserve[j]){
	                    answer++;
	                    reserve[j] = -1;
	                    break;
	                }
	            }
	        }        

	                
	        return answer;
	    }
	}
}

package 이공이삼삼월.d230310;

import java.util.PriorityQueue;

public class 더맵게 {
	class Solution {
	    public int solution(int[] scoville, int K) {
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        int answer = 0;
	    
	        for(int i=0; i<scoville.length; i++){
	            pq.offer(scoville[i]);
	        }
	        
	        while(!pq.isEmpty()){
	            
	            int curr = pq.poll();
	            
	            if(curr<K){
	                if(pq.size()==0){
	                    return -1;
	                }
	                
	                int next = pq.poll();
	                int mix = curr + next*2;
	                pq.offer(mix);
	                answer++;
	            }
	            
	        }
	        
	        return answer;
	    }
	}
}

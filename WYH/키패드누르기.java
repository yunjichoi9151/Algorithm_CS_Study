package day1112;

public class 키패드누르기 {
	public static void main(String[] args) {
		
	}
	
	 public String solution(int[] numbers, String hand) {
	        String answer = "";
	        // * = 10, 0 = 11, # = 12
	        int left = 10;
	        int right = 12;
	        
	        for(int num:numbers) {
	        	if(num==1||num==4||num==7) {
	        		answer += "L";
	        		left = num;
	        	}
	        	
	        	else if(num==3||num==6||num==9) {
	        		answer += "R";
	        		right = num;
	        	}
	        	else {
	        		if(num==0) num = 11;
	        		int ld = Math.abs(num-left)/3 + Math.abs(num-left)%3; // 왼손 현재위치와 입력값 거리
	        		int rd = Math.abs(num-right)/3 + Math.abs(num-right)%3;	// 오른손
	        		
	        		
	        		if(ld<rd) {
	        			answer += "L";
	        			left = num;
	        		}else if(rd<ld) {
	        			answer += "R";
	        			right = num;
	        		}else {
	        			if(hand.equals("left")) {
	        				answer += "L";
	        				left = num;
	        			}else {
	        				answer += "R";
	        				right = num;
	        			}
	        		}
	        	}
	        }
	        return answer;
	    }
}

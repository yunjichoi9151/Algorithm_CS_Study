package d221204;
//A팀 출전선수를 아는 이상 A팀 출전 선수 순서에 맞춰 이길 수 있는 선수를 내보내는 전략으로
//순서에 맞추기보다는 가장 큰 숫자부터 하나씩 격파하는 식으로 가기

import java.util.Arrays;

public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        //가장 끝 인덱스=가장 큰 수부터 매칭
        int idxA = A.length-1;
        int idxB = B.length-1;
        
        //A나 B가 패를 소진할때까지
        while(idxA>=0 && idxB>=0){
        	
            if(A[idxA]<B[idxB]){ 
            	
                answer++; //승리 승점 추가
                idxA--; idxB--;
                
            }else{//B와 비기거나 질 경우 B가 이길 수 있는 선수를 찾을때까지 돌리기
            	
                idxA--; 
            }
        }
        
        return answer;
    }
}

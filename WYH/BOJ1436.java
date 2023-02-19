package day0210;

import java.util.Scanner;

public class BOJ1436 {
	public static void main(String[] args) {
		// 6이 연속으로 3번 이상 들어가는 숫자 -> 종말의 수
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int n = 666;
		int cnt = 1;
		
		while(cnt != num) {
			n++;
			if(String.valueOf(n).contains("666")) {
				cnt++;
			}
			
		}
		
		System.out.println(n);
		
		
		
		
		
	}
}

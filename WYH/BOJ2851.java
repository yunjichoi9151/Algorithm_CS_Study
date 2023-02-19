package day0210;

import java.util.Scanner;

public class BOJ2851 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mushroom = new int[10];
		for (int i = 0; i < 10; i++) {
			mushroom[i] = sc.nextInt();
		}
		int score = 0;
		int before = 0;
		int after = 0;
		for (int i = 0; i < 10; i++) {
			score += mushroom[i];
			if (score == 100) {
				break;
			} else if (score < 100) {
				before = score;
//				continue;
				
			} else if (score > 100) {
				after = score;
				if(Math.abs(before-100)<after-100) {
					score = before;
					break;
				}else {
					score = after;
					break;
				}
			}
			
		}
		
		System.out.println(score);

	}
}

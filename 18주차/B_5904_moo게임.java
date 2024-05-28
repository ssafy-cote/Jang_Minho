package ssagako;

import java.util.Scanner;

/**
 * S(0) = "m o o" 
 * S(1) = "m o o m o o o m o o" 
 * S(2) = "m o o m o o o m o o m o o o o m o o m o o o m o o"
 */
public class B_5904_moo게임 {
	static int[] moolen;
	static String moo;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int moolen = 3;
		int reps = 4;
		while(moolen < N) {
			moolen = 2*moolen + reps++;
		}
		reps--;
		int place = N;
		recur(moolen, reps, place);
	}
	
	public static void recur(int moolen, int reps, int place) {
		if(moolen == 3) {
			if(place==1) System.out.println("m");
			else System.out.println("o");
			return;
		}
		
		int prevLen = (moolen - reps)/2;
		if(place > prevLen + reps) recur(prevLen, reps-1, place-(prevLen+reps));
		else if (place == prevLen+1||place==1) System.out.println("m");
		else if (place <= prevLen) recur(prevLen, reps-1, place);
		else System.out.println("o");
	}
}

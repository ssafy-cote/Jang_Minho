package test;

import java.util.Scanner;

public class Baekjoon_2389 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int five = T / 5;
		int last = T % 5;
		if (last == 0) {
			System.out.println(five);
			return;
		}
		while (five > 0) {
			if ((T - (five * 5)) % 3 == 0) {
				System.out.println(five + (T - (five * 5)) / 3);
				return;
			}
			five--;
		}
		System.out.println(-1);

	}

}

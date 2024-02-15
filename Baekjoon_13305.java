package test;

import java.util.Scanner;
/*
 * 메모리 : 187076 KB
 * 실행시간 : 1156 ms
 */
public class Baekjoon_13305 {
	static long[] city, road;
	static long answer;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		city = new long[N + 1];
		road = new long[N];
		
		for (int i = 1; i < N; i++) {
			road[i] = sc.nextLong();
		}
		for (int i = 1; i < N + 1; i++) {
			city[i] = sc.nextLong();
		}
		Ride(1);
		System.out.println(answer);
	}
	
	private static void Ride(int idx) {
		//if (idx == N - 1) return;
		if (idx == N - 1) {
			answer += city[idx] * road[idx];
			return;
		}
		
		long len = road[idx];
		for (int i = idx + 1; i < N; i++) {
			if (city[i] > city[idx]) len += road[i];
			else {
				answer += city[idx] * len;
				Ride(i);
				return;
			}
		}
		//끝까지 갔을 경우에도 answer에 더해줌
		answer += city[idx] * len;
		
	}
	
}

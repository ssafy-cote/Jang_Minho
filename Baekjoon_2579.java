package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 * [BrainStorm]
 * 마지막 계단 기준
 * -2번째 계단 이후 마지막 계단 밟는 경우
 * -3번재 계단, -1번째 계단, 그리고 마지막 계단
 * 
 * [다른 사람 답 참조]
 * dp[1]번째부터 시작함.
 * dp[나 - 2] + 내꺼 or
 * dp[나 - 3] + dp[나 - 1] + 내꺼
 * 나 - 3 > 0 이어야 함 : 나는 4부터 시작.
 */
public class Baekjoon_2579 {
	static int N;
	static int[] stair;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stair = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		//1 ~3 까지는 규칙이 딱히 없는듯?
		dp[1] = stair[1];
		dp[2] = stair[2] + stair[1];
		dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
		
		for (int i = 4; i <= N; i++) {
			dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
		}
		System.out.println(dp[N]);
	}
}

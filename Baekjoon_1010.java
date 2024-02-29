package asdf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * 참고 : 파스칼의 삼각형, 이항계수 정리
 * 조합으로 풀면 시간초과남
 * 
 * @author SSAFY
 *
 */
public class Baekjoon_1010 {
	static int N, M, ans;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new int[M+1][N+1];	// M개중에 N개 뽑기
			for (int i = 1; i <= M; i++) {	//0Cx는 없음
				for (int j = 0; j <= N; j++) {
					if (j==0) dp[i][j] = 1; // 파스칼 삼각형 좌변
					else if (j==i) dp[i][j] = 1;	// 파스칼 삼각형 우변
					else dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				}
			}
			System.out.println(dp[M][N]);
		}	
	}
}

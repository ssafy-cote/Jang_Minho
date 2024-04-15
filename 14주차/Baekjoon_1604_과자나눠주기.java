package ssagako;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 조카 수 M
 * 과자 수 N
 * 과자 길이 다다르
 * 
 * ->
 * 최대 길이 1이라 할때 
 * 과자마다 몇개 나오는지 합치기
 * 그 수가 >=M 이면 더 길게 시도
 * 
 * Max로 시도
 * 그 수가 < M이면 반절 줄이기
 * 하한선 : 1
 * 상한선 : max
 * 그 다음 : 현재 + 상항or하한 / 2
 * 
 * 그전 길이가 그 후 길이와 같다면 끝
 */
public class Baekjoon_1604_과자나눠주기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int low = 1;
		int high = arr[arr.length-1];
		int curr = (high+1)/2;
		int ans = 0;
		while(low <= high) {
			curr = (high + low) / 2;
			int temp = 0;
			for(int i = 0; i < arr.length; i++) {
				temp += arr[i] / curr;
			}
			if(temp >= M) {
				low = curr + 1;
				ans = curr;
			} else {
				high = curr - 1;
			}
			
		}
		System.out.println(ans);

	}

}

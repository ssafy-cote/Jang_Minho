package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * [BrainStrom]
 * 최소 한개의 모음 / 최소 두개의 자음
 * (모음은 다섯개 뿐)
 * 1. 먼저 모음을 몇개로 할지와 위치를 정함.
 * 2. 모음 순열 * 자음 순열
 * 3. 사전식으로 어떻게 출력할 것이냐?
 * 
 * [Re]
 * 단순하게 생각하기.
 * 사전 정렬 후 조합하기.
 * 이 때 자음 개수 2개, 모음개수 1개만 넘으면 됨
 * 
 */
public class Baekjoon_1759 {
	static boolean[] vowel, consonant, isSelected;
	static int L, C;
	static String[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[C];
		vowel = new boolean[C];
		consonant = new boolean[C];
		isSelected = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken();
		}
		Arrays.sort(arr);
		for (int i = 0; i < C; i++) {
			if (arr[i].equals("a") ||
					arr[i].equals("e") ||
					arr[i].equals("i") ||
					arr[i].equals("o") ||
					arr[i].equals("u")) {
					vowel[i] = true;
				} else {
					consonant[i] = true;
				}
		}
		Combi(0, 0, 0);
		
	}
	private static void Combi(int cnt, int vow, int con) {
		if (cnt == C) {
			if (vow + con != L) return;
			if (vow < 1 || con < 2) return;			
			for (int i = 0; i < C; i++) {
				if (isSelected[i]) System.out.print(arr[i]);
			}
			System.out.println();
			return;
		}
		if (vowel[cnt]) {
			isSelected[cnt] = true;
			Combi(cnt + 1, vow + 1, con);
			isSelected[cnt] = false;
			Combi(cnt + 1, vow, con);
		} else {
			isSelected[cnt] = true;
			Combi(cnt + 1, vow, con + 1);
			isSelected[cnt] = false;
			Combi(cnt + 1, vow, con);
		}
	}
}

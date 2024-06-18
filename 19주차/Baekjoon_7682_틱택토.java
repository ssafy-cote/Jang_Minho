package ssagako;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * 메모리 : 20232 KB
 * 실행시간 : 164ms
 */
/*
 * list생성 (좌표, 말)
 * 순서 정하기(순열)
 * 말을 놓을 때마다 
 * 	1. 아직 말이 남았는데 게임이 끝나면 빠구
 * 
 * 말을 다 놨는데 게임이 안끝났으면 빠꾸
 * 
 * 순열 : 
 * 	순열함수를 두개 생성해서 상호호출
 */
public class Baekjoon_7682_틱택토 {
	
	static char[][] matrix, map;
	static List<int[]> XList, OList;
	static boolean[] XisSelected, OisSelected;
	static int[][] selected;
	static int XOsize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String ln = br.readLine();
			if(ln.equals("end")) break;
			matrix = new char[3][3];
			XList = new ArrayList<>();
			OList = new ArrayList<>();
			for(int i = 0; i < ln.length(); i++) {
				matrix[i/3][i%3] = ln.charAt(i);
				if(matrix[i/3][i%3]=='X') XList.add(new int[] {i/3, i%3});
				else if(matrix[i/3][i%3]=='O') OList.add(new int[] {i/3, i%3});
			}
			if(Math.abs(XList.size()-OList.size())>1) {
				
				System.out.println("invalid");
				continue;
			}
			XisSelected = new boolean[XList.size()];
			OisSelected = new boolean[OList.size()];
			selected = new int[XList.size()+OList.size()][];
			XOsize = selected.length;
			if(PermuX(0)) System.out.println("valid");
			else System.out.println("invalid");
		}
	}
	
	private static boolean PermuX(int depth) {
		if(depth==XOsize) {
			return DoGame();
		}
		
		for(int i = 0; i < XList.size(); i++) {
			if(XisSelected[i]) continue;
			
			XisSelected[i] = true;
			selected[depth] = new int[] {XList.get(i)[0], XList.get(i)[1]};
			if(PermuO(depth+1)) return true;
			XisSelected[i] = false;
		}
		return false;
	}
	private static boolean PermuO(int depth) {
		if(depth==XOsize) {
			return DoGame();
		}
		
		for(int i = 0; i < OList.size(); i++) {
			if(OisSelected[i]) continue;
			
			OisSelected[i] = true;
			selected[depth] = new int[] {OList.get(i)[0], OList.get(i)[1]};
			if(PermuX(depth+1)) return true;
			OisSelected[i] = false;
		}
		return false;
	}
	
	private static boolean DoGame() {
		map = new char[3][];
		for(int i = 0; i < 3; i++) {
			map[i] = new char[] {'.', '.', '.'};
		}
		
		for(int i = 0; i < selected.length; i++) {
			int[] co = selected[i];
			// X부터 시작
			map[co[0]][co[1]] = i%2==0?'X':'O';
			if(isDone()) {
				if(i==selected.length-1) return true;
				else return false;
			}
		}
		return false;
	}
	
	private static boolean isDone() {
		return(Horizon()||Verizon()||diag1()||diag2()||cnt());
	}
	//가로
	static private boolean Horizon() {
		horizon:
		for(int i = 0; i < 3; i++) {
			if(map[i][0]=='.') continue;
			for(int j = 1; j < 3; j++) {
				if(map[i][j]!=map[i][0]) continue horizon;
			}
			return true;
		}
		return false;
	}
	//세로
	static private boolean Verizon() {
		verizon:
		for(int i = 0; i < 3; i++) {
			if(map[0][i]=='.') continue;
			for(int j = 1; j < 3; j++) {
				if(map[j][i]!=map[0][i]) continue verizon;
			}
			return true;
		}
		return false;
	}
	//대각
	static private boolean diag1() {
		for(int i = 1; i < 3; i++) {
			if(map[0][0]=='.'||map[i][i]!=map[0][0]) {
				return false;
			}
		}
		return true;
	}
	static private boolean diag2() {
		for(int i = 1; i < 3; i++) {
			if(map[0][2]=='.'||map[i][2-i]!=map[0][2]) return false;
		}
		return true;
	}
	//아무도 못이기고 꽉 차지도 않았으면 게임 계속 진행
	static private boolean cnt() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(map[i][j]=='.') return false;
			}
		}
		return true;
	}
	
	

}

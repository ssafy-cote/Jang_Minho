import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PG_NQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solution(sc.nextInt());
        System.out.println(answer);
    }

    static int[][] matrix;
    static int N, answer;
    static List<int[]> queens = new ArrayList<>();
    public static int solution(int n) {
        matrix = new int[n][n];
        queens = new ArrayList<>();
        N = n;
        answer = 0;
        nQueen(0);
        return answer;
    }

    public static void nQueen(int depth) {
        if (depth == N) {
            answer++;
//            queens.remove(queens.size()-1);
            return;
        }
        col:
        for(int i = 0; i < N; i++) {
            // 같은 col, 또는 대각선에 이미 Queen 있는지 체크
            for(int[] queen : queens) {
                if(queen[1] == i
                        ||Math.abs(queen[0]-depth)==Math.abs(queen[1]-i)) {continue col;}
            }
            queens.add(new int[]{depth, i});
            nQueen(depth+1);
            queens.remove(queens.size()-1);
        }
    }
}


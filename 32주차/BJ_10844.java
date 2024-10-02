import java.util.Arrays;
import java.util.Scanner;

/**
 * 100자리 -> 1000...0 부터 999...9 -> 900...0 개 -> 9 x 10^100 번 세야됨
 *
 * [1의 자리 수 기준으로 세기] + 2차원 dp
 * n+1자리 수 중 1의자리수가 0~9인 수 (dp[n+1][0~9]) 는 dp[n][i-1] + dp[n][i+1]
 * -> 끝자리수에서 +-1만 고려
 *
 */
public class BJ_10844 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] dp = new int[N+1][10];
        Arrays.fill(dp[1],1);
        dp[1][0] = 0;

        for(int i = 2; i <= N; i++){
            dp[i][0] = dp[i-1][1];
            for(int j = 1; j < 9; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
            dp[i][9] = dp[i-1][8];
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + dp[N][i]) % 1000000000;
        }
        System.out.println(ans);

    }
}

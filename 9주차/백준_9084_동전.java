import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_9084_동전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] coin = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(coin);
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            System.out.println(dp(N, coin, money));
        }
    }
    private static int dp(int N, int[] coin, int money) {
        int[][] dp = new int[money+1][N];
        for (int i = 1; i <= money; i++) {
            for (int j = 0; j < N; j++) {
                if (i < coin[j]) dp[i][j] = 0;
                else if (i == coin[j]) dp[i][j] = 1;
                else {
                    for (int k = j; k < N; k++) {
                        dp[i][j] += dp[i-coin[j]][k];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += dp[money][i];
        }
        return ans;

    }
}

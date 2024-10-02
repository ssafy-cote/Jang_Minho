import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2차원 dp
 * but, 1차원 dp를 계속해서 업데이트 하는 식으로 2차원으로 안만들어도 됨
 * 먼저, arr[0] 동전으로 N원을 만드는 경우의 수만 dp에 채움
 * 그다음, dp를 arr[0] 동전 + arr[1] 동전을 사용해서 N원을 만드는 경우의 수로 업데이트
 *  => dp[i] = dp[i] + dp[i-arr[1]](arr[1]동전을 한번만 써서 만들기)
 *  * 이때, i-arr[1]에서 arr[1]동전을 두번 이상 쓰는 경우가 어떻게 포함되느냐?
 *  * 그러한 경우는 i-arr[1]보다 먼저 업뎃되어 있음
 */
public class BJ_2293 {
    public static int N, K;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        //dp[0]도 필요함. 0원 + k원 동전 사용의 경우
        int[] dp = new int[K+1];
        dp[0] = 1;

        // arr[0] 동전만 쓴다고 했을 때
        int coin = arr[0];
        for(int i = 1; i <= K; i++){
            if(i % coin == 0){dp[i] = 1;}
        }

        // arr[1] 동전부터 사용가능 영역에 끼워줌
        for (int i = 1; i < N; i++) {
            coin = arr[i];
            for (int j = coin; j <= K; j++) {
                dp[j] = dp[j] + dp[j-coin];
            }
        }

        System.out.println(dp[K]);

    }
}

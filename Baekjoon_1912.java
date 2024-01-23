import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1912 {
    static int N;
    static Integer[] dp;
    static int[] arr;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        dp = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];
        ArraySum(N-1);
        Arrays.sort(dp);
        System.out.println(dp[N-1]);
    }

    public static int ArraySum(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(ArraySum(N-1) + arr[N], arr[N]);
        }
        return dp[N];
    }

}
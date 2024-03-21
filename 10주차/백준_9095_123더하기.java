import java.util.Scanner;

/**
 * 메모리 : 17724 KB
 * 시간 : 208 ms
 */
public class 백준_9095_123더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[12];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4;  i <= 11; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            System.out.println(arr[N]);
        }
    }
}

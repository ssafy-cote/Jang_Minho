import java.util.Scanner;


/**
 * 메모리 : 21596 KB
 * 시간 : 216 ms
 * 00 타일을 쓰는 개수에 따라 생각하기
 * N = 10일 떄 (짝수)
 * 00 타일 0개 : 0 0개를 배치하는 경우의 수 (10C0)
 * 00 타일 1개 : N=9라고 생각하고 0 1개를 배치하는 경우의 수 (9C1)
 * 00 타일 2개 : N=8라고 생각하고 0 2개를 배치하는 경우의 수 (8C2)
 * ...
 *  10C0 + 9C1 + 8C2 + 7C3 .. + 5C5
 *
 * 1안 : 그대로 계산
 * 시간 복잡도 : N <= 100만
 * (N/2) * Combi함수 호출 개수(0 + ... + (N/2)) -> 시초
 *
 * 2안 : 파스칼의 삼각형
 * f(10) = 10C0 + 9C1 + 8C2 + 7C3 .. + 5C5
 * f(9) = 9C0 + 8C1 + 7C2 + 6C3 ...
 * f(8) = 8C0 + 7C1 + 6C3 + ...
 * 이때,
 * 9C1 of f(10) = 8C0 of f(8) + 8C1 of f(9)
 * 8C2 of f(10) = 7C1 of f(8) + 7C2 of f(9)
 * 따라서, f(n+2) = f(n+1) + f(n) (그려보셈)
 *
 * 다만, 숫자가 너무 커 long으로 불가
 * BigInteger는 메모리 초과
 * mod연산은 결합법칙이 성립
 * 따라서, 모든 항을 mod 연산으로 넣어줌
 */
public class Baekjoon_1904_01타일 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // N = 1인 경우를 고려하여 ArrayIndexOutOfBoundError를 피하기 위해 N+2로 선언
        int[] arr = new int[N+2];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= N; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 15746;
        }
        System.out.println(arr[N]);
    }

}

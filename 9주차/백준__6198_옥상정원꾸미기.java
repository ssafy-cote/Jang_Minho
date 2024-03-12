import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 메모리 : 96820 KB
 * 실행시간 : 912 ms
 * 1. stack에 처음부터 집어넣기
 * 2. peek보다 크면 peek보다 작은게 나올 때까지 pop.
 * 3. 이 때 pop한 stack의 길이만큼 더해줌
 */
public class 백준__6198_옥상정원꾸미기 {
    public static void main(String[] args) {
        long answer = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Deque<Integer> st = new ArrayDeque<>();
        st.push(arr[0]);
        for (int i = 1; i < N; i++) {
            while(!st.isEmpty()&&st.peek() <= arr[i]) {
                st.pop();
                answer += st.size();
            }
            st.push(arr[i]);
        }
        // 다 끝난후의 st는 무조건 내림차순.
        answer += (st.size() * (st.size()-1)) / 2;
        System.out.println(answer);
    }
}

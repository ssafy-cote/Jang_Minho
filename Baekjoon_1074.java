import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1074 {
    static int N, R, C;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static int Zet(int offset) {
        if (offset > N) return 1;

        int size = (int)Math.pow(2, N - offset);
        if (R < size) {
            if (C < size) {
                // 2사분면
                return Zet(offset + 1);
            } else {
                // 1사분면
                C -= size;
                return Zet(offset + 1) + (int)Math.pow(size, 2);
            }
        } else{
            if (C < size) {
                // 3사분면
                R -= size;
                return Zet(offset + 1) + (int)Math.pow(size, 2) * 2;
            } else {
                // 4사분면
                R -= size;
                C -= size;
                return Zet(offset + 1) + (int)Math.pow(size, 2) * 3;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(Zet(1) - 1);
    }
}
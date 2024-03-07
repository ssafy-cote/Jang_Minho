import java.util.*;

public class PG_귤고르기 {
    static HashMap<Integer, Integer> hm;
    public static int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        int size = tangerine[0];
        int sizeNum = 1;
        List<Integer> tl = new ArrayList<>();
        for (int i = 1; i < tangerine.length; i++) {
            if (tangerine[i]==size) {
                sizeNum++;
            } else {
                tl.add(sizeNum);
                sizeNum = 1;
                size = tangerine[i];

            }
            if (i == tangerine.length - 1) tl.add(sizeNum);
        }
        tl.sort((s1, s2)->s2.compareTo(s1));
        int ts = 0;
        int ans = 0;
        for (int num : tl) {
            if (ts + num >= k) return ans + 1;
            else {
                ts += num;
                ans++;
            }
        }
        return 1;

    }
    public static void main(String[] args) {
        System.out.println(solution(15, new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5}));
    }
}

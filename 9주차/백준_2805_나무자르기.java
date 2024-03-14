import java.util.Scanner;

/**
 * 메모리 : 319500 KB
 * 실행시간 : 1780 ms
 */
public class 백준_2805_나무자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] trees = new int[N];
        int minTree = Integer.MAX_VALUE;
        int maxTree = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
            minTree = Math.min(minTree, trees[i]);
            maxTree = Math.max(maxTree, trees[i]);
        }
        //초기값은 maxtree의 반 : mintree는 생각해주는거아님 - 다 잘라야 하는 경우도 있음
        int height = maxTree/2;
        // 정답이 maxtree와 같은 경우에 maxtree를 갈 수 가 없음 : 최댓값을 maxtree + 1로 설정
        int maxHeight = maxTree + 1;
        int minHeight = 0;
        long prevSum = -1;
        while(true) {
            long treesum = 0;
            for (int i = 0; i < N; i++) {
                treesum +=  Math.max(trees[i] - height, 0);
            }
            if (prevSum==treesum) break;
            else prevSum = treesum;
            if (treesum >= M) {
                minHeight = height;
                height = (maxHeight + height) / 2;
            }
            else {
                maxHeight = height;
                height = (minHeight + height) / 2;
            }
        }
        System.out.println(height);
    }
}

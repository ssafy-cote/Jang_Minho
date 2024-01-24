import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        for (int a : s.solution(new int[]{5, 4, 3, 2, 1})) {
            System.out.println(a);
        }

    }



}
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> st = new Stack<>();

        /*
        마지막 항은 무조건 0초이고, min값은 자기 자신이다.
        그 전항은, 뒤에 min값과 비교해서 작은값이 있으면 그 인덱스를 받아야 한다.
         */
        for (int i = 0; i < answer.length; i++) {
            while (!st.isEmpty() &&prices[i] < prices[st.peek()]) {
                answer[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            answer[st.peek()] = prices.length - st.peek() - 1;
            st.pop();
        }

        return answer;
    }
}
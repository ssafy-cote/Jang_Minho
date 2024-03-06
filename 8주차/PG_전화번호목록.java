import java.util.Arrays;

/**
 * Arrays.sort<String>() ->
 *     1순위 : 가장 앞자리의 아스키코드값 (오름차순 )
 *     2순위 : length 오름차순
 *
 * 11, 111, 12 순으로 정렬됨
 * 1-2번째, 2-3번째, 3-4번째.. 만 비교하면됨
 *
 */
public class PG_전화번호목록 {
    class Solution {
        public boolean solution(String[] phone_book) {
            Arrays.sort(phone_book);
            for (int i = 0; i < phone_book.length-1; i++) {
                if (phone_book[i+1].startsWith(phone_book[i]))
                    return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {

    }
}

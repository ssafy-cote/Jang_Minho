public class 프로그래머스_2개이하로_다른비트 {
    public static void main(String[] args) {

        for (long num:solution(new long[]{2, 7})) {
            System.out.println(num);
        }
    }
    public static long[] solution(long[] numbers) {
        long flag = 1;
        for(int i=0; i < numbers.length; i++) {
            int offset = 0;
            while((numbers[i] & (flag << offset)) == (flag << offset)) {
                offset++;
            }
            numbers[i] |= flag<<offset;
            if (offset != 0) {
                numbers[i] &= ~(flag<<(offset-1));
            }


        }
        return numbers;
    }
}




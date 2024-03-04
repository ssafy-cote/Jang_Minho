import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 메모리 : 14052 KB
 * 실행시간 : 120 ms
 * 클래스 만들기
 * 정렬
 */
public class Baekjoon_5635_생일 {
    static class person implements Comparable<person>{
        String name;
        int dd;
        int mm;
        int yyyy;
        person(String n, int d, int m, int y) {
           this.name = n;
           this.dd = d;
           this.mm = m;
           this.yyyy = y;
        }

        @Override
        public int compareTo(person o) {
            return Integer.compare(o.yyyy, this.yyyy)==0?
                    Integer.compare(o.mm, this.mm)==0?
                    Integer.compare(o.dd, this.dd):
                    Integer.compare(o.mm, this.mm):
                    Integer.compare(o.yyyy, this.yyyy);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<person> pList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            pList.add(new person(name, day, month, year));
        }
        Collections.sort(pList);
        System.out.println(pList.get(0).name);
        System.out.println(pList.get(pList.size()-1).name);
    }
}

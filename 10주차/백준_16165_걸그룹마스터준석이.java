import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_16165_걸그룹마스터준석이 {
    static int N, M;
    static HashMap<String, List<String>> girlGroups;
    static HashMap<String, String> girls;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        girlGroups = new HashMap<>();
        girls = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String group = st.nextToken();
            List<String> nGroup = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int groupN = Integer.parseInt(st.nextToken());
            for (int j = 0; j < groupN; j++) {
                String girl = br.readLine();
                nGroup.add(girl);
                girls.put(girl, group);
            }
            Collections.sort(nGroup);
            girlGroups.put(group, nGroup);
        }

        for (int i = 0; i < M; i++) {
            String qst = br.readLine();
            int qstType = Integer.parseInt(br.readLine());
            if (qstType==1) {
                System.out.println(girls.get(qst));
            } else {
                for (String g : girlGroups.get(qst)) {
                    System.out.println(g);
                }
            }
        }
    }

}

import java.util.ArrayDeque;
import java.util.Queue;

/*
[BrainStorm]
최단거리로 가는법 (BFS)
큐 생성 : BFS는 큐 + 반복, DFS는 스택 + 재귀
1. 첫째 지점부터 큐에 담기
2. 사방탐색 후 visited = 0이면 한칸 큐에 담기 + 거리 지도도 1 늘림
3. 만약 큐에서 꺼내 방문하다가 이미 방문한 곳에 다다름 : 최단경로 탈락
4. bfs이기때문에 시작지점으로부터 같은 거리인 지점은 항상 너비 이내의 시간 안에 방문하기 때문에
내가 해당 지점을 두번쨰로 방문한 경로라면 나의 거리는 첫번째 방문한 경로보다 같거나 큼
5. 결국 한 경로만이 끝까지 큐에 남아 방문함
 */
public class PG_GameShortCut_BFS {

    int[][] dt = {{-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}};

    public int solution(int[][] maps) {
        int answer = 0;
        Queue<int[]> q = new ArrayDeque<>();
        int[][] distMap = new int[maps.length][maps[0].length];
        int[][] visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1;
        distMap[0][0] = 1;
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] d : dt) {
                int dx = curr[0] + d[0];
                int dy = curr[1] + d[1];
                if (dx < 0 || dx >= maps.length || dy < 0 || dy >= maps[0].length) continue;
                if (maps[dx][dy] == 1 && visited[dx][dy] == 0) {
                    q.add(new int[]{dx, dy});
                    visited[dx][dy] = 1;
                    distMap[dx][dy] = distMap[curr[0]][curr[1]] + 1;
                }
            }
        }
       if (distMap[maps.length - 1][maps[0].length - 1] == 0) answer = -1;
       else answer = distMap[maps.length - 1][maps[0].length - 1];
       return answer;
    }
}
package solving;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class p24463 {
    // 1. 입력 생각하기
    // 별다른 조건은 없어도 되는 듯하다.
    // 2. 구현 생각하기
    // BFS 문제인 것 같다.
    // 최단 경로길래 BFS인줄 알았는데 DFS로 모든 노드를 방문하고
    // 아닌 부분은 빠져나오면서 .을 @로 대체하는 문제인 것 같다.
    // 시간초과가 발생함.
    // -> 풀이를 찾아보니 .을 @로 바꾼 뒤에
    // BFS로 최단 경로를 찾고, 최단 거리로 온 경로를 저장한 뒤에
    // 뒤로 걸어가면서 나오는 경로를 .으로 다시 고쳤다고 한다.
    // https://bacchus-lover.tistory.com/284
    static String[][] map;
    static int[] dX = {0,0,-1,1};
    static int[] dY = {1,-1,0,0};
    static boolean[][] visited;

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]);
        M = Integer.parseInt(nums[1]);
        map = new String[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++) {
            String[] temp = br.readLine().split("");
            for(int j = 0 ; j < M ; j++) {
                if(temp[j].equals(".")) {
                    map[i][j] = "@";
                } else {
                    map[i][j] = temp[j];
                }
            }
        }
        dfs(0,0);

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int startY, int startX) {
        visited[startY][startX] = true;

        if (map[startY][startX].equals(".")) {
            //현재 위치가 미로의 길이라면
            int count = 0;
            for(int i = 0 ; i < 4 ; i++) {
                int nextY = startY + dY[i];
                int nextX = startX + dX[i];

                if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    //맵의 범위를 벗어나는지 체크
                    if (map[nextY][nextX].equals("+") || map[nextY][nextX].equals("@")) {
                        count++;
                    }
                }
            }
            if(count >= 3) {
                map[startY][startX] = "@";
            }
        }

        for(int i = 0 ; i < 4 ; i++) {
            int nextY = startY + dY[i];
            int nextX = startX + dX[i];

            if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                //다음 탐색의 범위 계산
                if(!visited[nextY][nextX]) {
                    //방문하지 않고 그 노드가 길이라면 방문한다.
                    dfs(nextY,nextX);
                }
            }
        }
        if (map[startY][startX].equals(".")) {
            //현재 위치가 미로의 길이라면
            int count = 0;
            for(int i = 0 ; i < 4 ; i++) {
                int nextY = startY + dY[i];
                int nextX = startX + dX[i];

                if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    //맵의 범위를 벗어나는지 체크
                    if (map[nextY][nextX].equals("+") || map[nextY][nextX].equals("@")) {
                        count++;
                    }
                }
            }
            if(count >= 3) {
                map[startY][startX] = "@";
            }
        }
    }
}

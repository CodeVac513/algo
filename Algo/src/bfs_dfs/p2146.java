package bfs_dfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p2146 {
    // 1.입력 생각하기
    // 100이하의 자연수 N을 입력받는다.
    // N * N 개의 숫자를 입력받는데 0은 바다, 1은 육지를 의미한다.
    // 두 개의 떨어진 육지를 연결하는데 가장 짧은 경로로 연결하고 그 길이를 출력한다.
    //
    // 2. 구현 방법
    // 섬은 dfs로 구역을 찾고, 최단거리의 다리는 bfs로 찾아내면?
    // dfs로 섬을 넓이를 계산하고(1로만 움직인다) 그 섬의 외곽을 Queue에 삽입한다.
    // Queue에 삽입된 노드를 꺼내서 0인(바다인) 부분만 움직여서 최초로 1이 닿는 곳을 찾는다.
    // 위의 과정을 반복하면 BFS로 최단거리를 잴 수 있지 않을까? 일단 해보자.
    // 잘 안풀려서 찾아보니 섬을 구역별로 나누고 BFS를 진행하는 형식으로 풀 수 있다고 한다.
    // 섬의 넓이를 계산하고 -> 이런 부분은 틀렸지만 DFS로 섬을 나누고 BFS로 최단거리를 찾는 문제이다.
    // 그렇다면 땅의 값을 1번섬은 1로 저장, 2번 섬은 2로 저장 이런식으로 저장한다.
    // 섬에 번호 할당이 끝나면 BFS를 통해서 같은 섬이 아닌 섬까지 길이의 최솟값을 구할 수 있다.

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static Queue<p2146Node> q = new LinkedList<>();
    static int N;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        //map이 N보다 큰 이유는 범위를 벗어나는 경우에 예외처리를 하지 않고 계산하기 위함.
        map = new int[N+2][N+2];
        int startX = -1, startY = -1;
        for(int i = 0 ; i < N+2 ; i++) {
            if(i == 0 || i == N+1) {
                Arrays.fill(map[i],-1);
            } else {
                String[] nums = br.readLine().split(" ");
                for(int j = 0 ; j < N+2 ; j++) {
                    if(j == 0 || j == N+1) {
                        map[i][j] = -1;
                    } else {
                        map[i][j] = Integer.parseInt(nums[j-1]);
                    }
                }
            }
        }

        visited = new boolean[N][N];

        for(boolean[] b : visited) {
            Arrays.fill(b,false);
        }

        int cnt = 1;
        for(int i = 1 ; i < N+1 ; i++) {
            for(int j = 1 ;  j < N+1 ; j++) {
                if(!visited[i-1][j-1] && map[i][j] != -1 && map[i][j] != 0) {
                    dfs(i,j,cnt);
                    cnt++;
                }
            }
        }




        for(int i = 1 ; i <= cnt ; i++) {
            int[][] bfsMap = map.clone();
            for(boolean[] b : visited) {
                Arrays.fill(b,false);
            }
            bfs(bfsMap,i);
        }

        bw.write(ans+"\n");
        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int startY, int startX,int count) {
        visited[startY - 1][startX - 1] = true;
        map[startY][startX] = count;

        for(int i = 0 ; i < 4 ; i++) {
            int nextY = startY + dy[i];
            int nextX = startX + dx[i];

            if(map[nextY][nextX] != -1) {
                if(!visited[nextY - 1][nextX - 1]) {
                    if(map[nextY][nextX] == 1 && !visited[nextY - 1][nextX - 1]) {
                        dfs(nextY,nextX,count);
                    }
                }
            }
        }
    }

    static void bfs(int[][] map, int count) {
        for(int i = 1 ; i < N+1 ; i++) {
            for(int j = 1 ; j < N+1; j++) {
                if(map[i][j] == count) {
                    q.add(new p2146Node(i,j,0));
                    visited[i - 1][j - 1] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            p2146Node current = q.poll();

            for(int i = 0 ; i < 4 ; i++) {
                    int nextY = current.y + dy[i];
                    int nextX = current.x + dx[i];
                    int depth = current.depth;

                    if(map[nextY][nextX] == -1)
                        continue;

                    if(map[nextY][nextX] != count && map[nextY][nextX] > 0) {
                        if(depth != 0 && ans > depth) {
                            ans = depth;
                        }
                    } else {
                        if(map[nextY][nextX] == 0 && !visited[nextY - 1][nextX - 1]) {
                            visited[nextY - 1][nextX - 1] = true;
                            q.add(new p2146Node(nextY,nextX,depth+1));
                        }
                    }
            }
        }
    }
}

class p2146Node {
    int x;
    int y;
    int depth;

    public p2146Node(int y, int x, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

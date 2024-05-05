package bfs_dfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p2178 {
    // 1. 입력 생각하기
    // N x M 크기의 map을 입력받는다.
    // 좌측 상단에서 출발하여 우측 하단까지 최소한의 칸을 이동하여 도착해야 한다.
    // 완전탐색으로 풀 수 있을 것 같다.
    // 항상 도착할 수 있는 입력만 주어지므로 따로 예외처리는 하지 않는다.
    // 2. 구현 방법
    // BFS나 DFS로 구현할 것인데, DFS는 좀 해보았으니 BFS로 구현해본다.
    // BFS로 구현하기 위해서는 Queue가 필요하다.
    // Queue의 이름을 q로 하나 선언, 노드를 방문했는지 표시할 배열 visited 선언, 좌표를 Node라는 클래스로 저장.
    // Node 클래스는 x,y 좌표와 depth를 가지는데 depth는 현재 노드의 깊이를 표현한다. (시작 노드부터 얼마나 이동했는지 알기위함)
    // 시작 위치에서 옮길 수 있는 모든 위치를 q에 저장한다. (상하좌우)
    // q에서 하나씩 꺼내어 방문한 노드를 visited - true로 설정한다.
    // 다음 이동할 수 있는 visited 값이 false인 모든 노드를 q에 넣는다.
    // 이렇게 반복하면 시작 노드와 연결되어 있는 모든 노드를 방문하게 되는데
    // 움직이다가 목표한 도착 위치 노드를 읽게 된다면 그 노드의 depth(깊이)를 반환한다.
    // 그 깊이를 출력하면 문제 해결.

    static int[][] map;
    static boolean[][] visited;
    static Queue<p2178Node> q = new LinkedList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]);
        M = Integer.parseInt(nums[1]);

        //map 메모리 할당 및 초기화와 값 입력받기
        map = new int[N+2][M+2];

        for(int i = 0 ; i < N + 2; i++) {
            if(i == 0 || i == N+1) {
                for(int j = 0 ; j < M+2 ; j++) {
                    map[i][j] = 0;
                }
            } else {
                String[] temp = br.readLine().split("");
                for(int j = 0 ; j < M+2 ; j++) {
                    if(j == 0 || j == M+1) {
                        map[i][j] = 0;
                    } else {
                        map[i][j] = Integer.parseInt(temp[j-1]);
                    }
                }
            }
        }

        //visited 메모리 할당 및 false로 초기화
        visited = new boolean[N][M];
        for (boolean[] b : visited) {
            Arrays.fill(b,false);
        }

        bw.write(bfs(1,1)+"\n");



        br.close();
        bw.flush();
        bw.close();
    }

    static int bfs(int startY,int startX) {


        visited[startY-1][startX-1] = true;
        q.offer(new p2178Node(startY,startX,1));
        while (!q.isEmpty()) {
            p2178Node current = q.poll();
            if(current.y == N && current.x == M)
                return current.depth;
            for(int i = 0 ; i < 4 ; i++) {
                int nextY = current.y + dy[i];
                int nextX = current.x + dx[i];
                int depth = current.depth;
                if(map[nextY][nextX] == 1) {
                    if(!visited[nextY - 1][nextX - 1]) {
                        visited[nextY - 1][nextX - 1] = true;
                        q.offer(new p2178Node(nextY, nextX,depth+1));

                    }
                }
            }
        }

        return 0;
    }
}

class p2178Node {
    int x;
    int y;
    int depth;
    public p2178Node(int y, int x, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

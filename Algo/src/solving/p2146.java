package solving;

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

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        //map이 N보다 큰 이유는 범위를 벗어나는 경우에 예외처리를 하지 않고 계산하기 위함.
        map = new int[N+2][N+2];

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

        for(int i = 0 ; i < N+2 ; i++) {
            for(int j = 0 ;  j < N+2 ; j++) {
                dfs(i,j);
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int startY, int startX) {

    }

    static int bfs() {

        return 0;
    }
}

class Node {
    int x;
    int y;
    int depth;

    public Node(int y, int x, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

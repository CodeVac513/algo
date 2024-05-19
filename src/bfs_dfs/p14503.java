package bfs_dfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p14503 {
    static int[][] map;
    static int[] dirY = {-1,0,1,0};
    static int[] dirX = {0,1,0,-1};
    static boolean[][] visited;
    static int N;
    static int M;
    static int ans = 1;

    //로봇이 바라보는 방향을 queue에 저장해서 관리를 하자.
    static Queue<Integer> direction = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        String[] robot = br.readLine().split(" ");
        int startY = Integer.parseInt(robot[0]);
        int startX = Integer.parseInt(robot[1]);
        int startDir = Integer.parseInt(robot[2]);

        //로봇이 반시계로 돌 때를 생각해서 입력된 방향에 따라 queue를 초기화하는 함수.
//        robotDirection(startDir);


        for(int i = 0; i < N ; i++) {
            String[] nums = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(nums[j]);
            }
            Arrays.fill(visited[i],false);
        }

        dfs(startY, startX, startDir);

        bw.write(ans+"\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int startY, int startX, int startDir) {
        visited[startY][startX] = true;

        for(int i = 0 ; i < 4 ; i++) {
            startDir = (startDir + 3) % 4;
            int nextY = startY + dirY[startDir];
            int nextX = startX + dirX[startDir];

            if(nextY>=0 && nextY < N && nextX >= 0 && nextX < M) {
                // map의 범위 안에 들어오는 index인지 판별
                if(map[nextY][nextX] == 0 && !visited[nextY][nextX]) {
                    // 다음 방이 청소할 수 있는 방이면 방문해서 청소.
                    ans++;
                    dfs(nextY,nextX,startDir);
                    return;
                }
//                else if(visited[nextY][nextX] || map[nextY][nextX] == 1){
////                    direction.offer(currentDir);
////                    currentDir = direction.poll();
//                }
            }
        }

        int back = (startDir + 2) % 4;
        int nextY = startY + dirY[back];
        int nextX = startX + dirX[back];
        if(nextY>=0 && nextY < N && nextX >= 0 && nextX < M) {
            if(map[nextY][nextX] != 1) {
                dfs(nextY,nextX,startDir);
            }
        }

    }

//    static void robotDirection(int dir) {
//
//        if (dir == 0) {
//            direction.offer(3);
//            direction.offer(2);
//            direction.offer(1);
//
//        } else if (dir == 1) {
//            direction.offer(0);
//            direction.offer(3);
//            direction.offer(2);
//
//        } else if (dir == 2) {
//            direction.offer(1);
//            direction.offer(0);
//            direction.offer(3);
//
//        } else if (dir == 3) {
//            direction.offer(2);
//            direction.offer(1);
//            direction.offer(0);
//        }
//    }
}

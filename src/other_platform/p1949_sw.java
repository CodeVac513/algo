package other_platform;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1949_sw {
    static int N, K, result;
    static int[][] map;
    static boolean[][] isVisited;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            init();

            int maxHeight = -1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(map[i][j], maxHeight);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (maxHeight != map[i][j]) continue;

                    isVisited[i][j] = true;
                    DFS(i, j, 1, map[i][j], K);
                    isVisited[i][j] = false;
                }
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    // 백트래킹을 통해서 등산로를 깎으면서 갈 수 있는 모든 길을 다 가봄.
    private static void DFS(int x, int y, int length, int height, int k) {
        // 최대 길이를 매번 갱신.
        result = Math.max(length, result);

        for (int i = 0; i < 4; i++) {
            int nowX = dirX[i] + x;
            int nowY = dirY[i] + y;

            if (!rangeCheck(nowX, nowY) || isVisited[nowX][nowY]) continue;

            if (k == 0) {
                if (map[nowX][nowY] < height) {
                    isVisited[nowX][nowY] = true;
                    DFS(nowX, nowY, length + 1, map[nowX][nowY], k);
                    isVisited[nowX][nowY] = false;
                }
            } else {
                if (map[nowX][nowY] < height) {
                    isVisited[nowX][nowY] = true;
                    DFS(nowX, nowY, length + 1, map[nowX][nowY], k);
                    isVisited[nowX][nowY] = false;
                } else if ((map[nowX][nowY] - k) < height) {
                    // 앞으로 가려고 하는 곳의 높이가. K만큼 깎았을 때, height 보다 낮을 경우 갈 수 있음
                    // map[nowX][nowY]가 갈 수 있다는 조건에서 높이가 딱 1차이만 나도록 깎아야함
                    isVisited[nowX][nowY] = true;
                    DFS(nowX, nowY, length + 1, height - 1, 0);
                    isVisited[nowX][nowY] = false;
                }
            }

        }

    } // End of DFS

    private static boolean rangeCheck(int nowX, int nowY) {
        return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N;
    } // End of rangeCheck

    private static void init() {
        map = new int[N][N];
        isVisited = new boolean[N][N];
        result = -1;
    }
}
//    static int[][] map;
//    static boolean[][] visited;
//    static int[] dy = {1,-1,0,0};
//    static int[] dx = {0,0,-1,1};
//    static int ans;
//    static int N;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int T = Integer.parseInt(br.readLine());
//
//        for(int test_case = 1 ; test_case <= T ; test_case++) {
//
//            String[] temp = br.readLine().split(" ");
//            //지도 한 변의 길이
//            N = Integer.parseInt(temp[0]);
//
//            //최대 공사 가능한 깊이
//            int K = Integer.parseInt(temp[1]);
//
//            //map 초기화 및 data 읽어서 map에 대입
//            map = new int[N][N];
//
//            int highest = Integer.MIN_VALUE;
//            for(int i = 0 ; i < N ; i++) {
//                String[] nums = br.readLine().split(" ");
//                for(int j = 0; j < N ; j++) {
//                    map[i][j] = Integer.parseInt(nums[i]);
//                    if(highest < map[i][j]) {
//                        highest = map[i][j];
//                    }
//                }
//            }
//
//            //visited 배열 초기화
//            visited = new boolean[N][N];
//            for(int i = 0 ; i < N ; i++) {
//                Arrays.fill(visited[i],false);
//            }
//
//            //정답을 저장할 ans 변수 초기화.
//            ans = -1;
//
//            for(int i = 0 ; i < N ; i++) {
//                for(int j = 0; j < N ; j++) {
//                    if(highest != map[i][j]) {
//                        continue;
//                    }
//                    visited[i][j] = true;
//                    dfs(i,j,1,map[i][j],K);
//                    visited[i][j] = false;
//                }
//            }
//
//            bw.write("#"+test_case+" "+ans+"\n");
//        }
//
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//
//    static void dfs(int startY, int startX, int length, int height, int k) {
//        //hight는 현재 등산로 높이, length는 현재 등산로 길이, k는 깎을 수 있는 깊이.
//        //등산로를 만들면서 움직일 때마다 최댓값을 갱신해준다.
//        ans = Math.max(length, ans);
//
//        for(int i = 0 ; i < 4 ; i++) {
//            int nextY = startY + dy[i];
//            int nextX = startX + dx[i];
//
//            if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < N ) {
//                if(k == 0) {
//                    if(map[nextY][nextX] < height) {
//                        visited[nextY][nextX] = true;
//                        dfs(nextY,nextX,length+1,map[nextY][nextX],k);
//                        visited[nextY][nextX] = false;
//                    }
//                } else {
//                    if(map[nextY][nextX] < height) {
//                        visited[nextY][nextX] = true;
//                        dfs(nextY,nextX,length+1,map[nextY][nextX],k);
//                        visited[nextY][nextX] = false;
//                    } else if(map[nextY][nextX] - k < height) {
//                        visited[nextY][nextX] = true;
//                        dfs(nextY,nextX,length+1,height-1,0);
//                        visited[nextY][nextX] = false;
//                    }
//                }
//            }
//
//        }
//    }


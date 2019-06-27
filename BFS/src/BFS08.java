//B7562 knight

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Point;
import java.io.FileInputStream;
 
public class BFS08 {
    static int l;
    static int[][] map;
    static int[][] visited;
    static ArrayList<Point> queue;
 
    public static void main(String args[]) throws Exception {
        // Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
 
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int test_case = 0; test_case < T; test_case++) {
            l = sc.nextInt();
 
            map = new int[l][l];
 
            int curr_x = sc.nextInt();
            int curr_y = sc.nextInt();
 
            int end_x = sc.nextInt();
            int end_y = sc.nextInt();
 
            visited = new int[l][l];
            queue = new ArrayList<Point>();
 
            BFS(curr_x, curr_y, end_x, end_y);
 
        }
 
    } // main
 
    static void BFS(int curr_x, int curr_y, int end_x, int end_y) {
        int[] move_x = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] move_y = { -1, -2, -2, -1, 1, 2, 2, 1 };
 
        int level = 0;
        visited[curr_x][curr_y] = 1;
        queue.add(new Point(curr_x, curr_y));
 
        while (queue.isEmpty() != true) {
            int queue_size = queue.size();
 
            for (int i = 0; i < queue_size; i++) {
                curr_x = queue.get(0).x;
                curr_y = queue.get(0).y;
                queue.remove(0);
 
                if (curr_x == end_x && curr_y == end_y) {
                    System.out.println(level);
                    break;
                }
 
                for (int j = 0; j < 8; j++) {
                    int next_x = move_x[j] + curr_x;
                    int next_y = move_y[j] + curr_y;
 
                    if (next_x < l && next_y < l && next_x >= 0 && next_y >= 0) {
                        if (visited[next_x][next_y] == 0) {
                            visited[next_x][next_y] = 1;
                            queue.add(new Point(next_x, next_y));
                        }
                    }
                }
 
            } // queue_size for
 
            level++;
        } // while
 
    } // BFS
 
}



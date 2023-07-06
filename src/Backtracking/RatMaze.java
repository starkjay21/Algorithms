package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class RatMaze {
    public static void main(String[] args) {
        int[][] m = {{0, 1, 1, 1},
                {1, 1, 1, 0},
                {1, 0, 1, 1},
                {0, 0, 1, 1}};
        int n = 4;
        ArrayList<String> list = findPath(m,n);
        for (String str:
             list) {
            System.out.println(str);
        }
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> list = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];
        allPath("", m, n, 0, 0, vis, list);
        return list;
    }
    static void allPath(String path, int[][] m, int n, int r, int c, boolean[][] vis, ArrayList<String> list){
        if(r == n-1 && c == n-1){
            list.add(path);
            return;
        }
        vis[r][c] = true;
        if(c > 0 && !vis[r][c-1] && m[r][c-1] != 0){
            path += 'L';
            allPath(path, m, n, r, c-1, vis, list);
            path = path.substring(0, path.length()-1);
        }
        if(r > 0 && !vis[r-1][c] && m[r-1][c] != 0){
            path += 'U';
            allPath(path, m, n, r-1, c, vis, list);
            path = path.substring(0, path.length()-1);
        }
        if(c < n-1 && !vis[r][c+1] && m[r][c+1] != 0){
            path += 'R';
            allPath(path, m, n, r, c+1, vis, list);
            path = path.substring(0, path.length()-1);
        }
        if(r < n-1 && !vis[r+1][c] && m[r+1][c] != 0){
            path += 'D';
            allPath(path, m, n, r+1, c, vis, list);
            path = path.substring(0, path.length()-1);
        }
        vis[r][c] = false;
    }
}

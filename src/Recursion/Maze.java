package Recursion;

import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
        int m = 4, n = 4;
        boolean vis[][] = new boolean[m][n];
        int[][] path = new int[m][n];
        allPath("", m, n, 0, 0, vis, path, 1);
    }
    static void allPath(String path, int m, int n, int r, int c, boolean[][] vis, int[][] arr, int step){
        if(r == m-1 && c == n-1){
            arr[r][c] = step;
            for (int i = 0; i < arr.length; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
            System.out.println(path);
            System.out.println();
        }
        vis[r][c] = true;
        arr[r][c] = step;
        if(c > 0 && !vis[r][c-1]){
            path += 'L';
            allPath(path, m, n, r, c-1, vis, arr, step+1);
            path = path.substring(0, path.length()-1);
        }
        if(r > 0 && !vis[r-1][c]){
            path += 'U';
            allPath(path, m, n, r-1, c, vis, arr, step+1);
            path = path.substring(0, path.length()-1);
        }
        if(c < n-1 && !vis[r][c+1]){
            path += 'R';
            allPath(path, m, n, r, c+1, vis, arr, step+1);
            path = path.substring(0, path.length()-1);
        }
        if(r < m-1 && !vis[r+1][c]){
            path += 'D';
            allPath(path, m, n, r+1, c, vis, arr, step+1);
            path = path.substring(0, path.length()-1);
        }
        vis[r][c] = false;
        arr[r][c] = 0;
    }
}

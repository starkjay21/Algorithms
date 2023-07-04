package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NKnights {
    public static void main(String[] args) {
        int n = 2;
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        List<char[][]> list = new ArrayList<>();
        System.out.println(knights(board, 0, 0, n, list));
        for (char[][] arr : list) {
            for (char[] chars : arr) {
                for (char aChar : chars) {
                    System.out.print(aChar + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    static int knights(char[][] board, int row, int col, int n, List<char[][]> list) {
        if (n == 0) {
            char[][] newBoard = new char[board.length][board.length];
            for (int i = 0; i < board.length; i++)
                System.arraycopy(board[i], 0, newBoard[i], 0, board.length);
            list.add(newBoard);
            return 1;
        }

        if(row == board.length-1 && col == board.length)
            return 0;

        if(col == board.length)
        {
            return knights(board, row+1, 0, n, list);
        }
        int count = 0;
        if (isSafe(board, row, col)) {
            board[row][col] = 'K';
            count += knights(board, row, col+1, n - 1, list);
            board[row][col] = '.';
        }
        count += knights(board, row, col+1, n, list);
        return count;
    }

    static boolean isSafe(char[][] board, int r, int c) {

        if (r >= 2 && c >= 1 && board[r - 2][c - 1] == 'K')
            return false;
        if (r >= 2 && c < board.length - 1 && board[r - 2][c + 1] == 'K')
            return false;
        if (r < board.length - 2 && c >= 1 && board[r + 2][c - 1] == 'K')
            return false;
        if (r < board.length - 2 && c < board.length - 1 && board[r + 2][c + 1] == 'K')
            return false;
        if (r >= 1 && c < board.length - 2 && board[r - 1][c + 2] == 'K')
            return false;
        if (r < board.length - 1 && c < board.length - 2 && board[r + 1][c + 2] == 'K')
            return false;
        if (r >= 1 && c >= 2 && board[r - 1][c - 2] == 'K')
            return false;
        if (r < board.length - 1 && c >= 2 && board[r + 1][c - 2] == 'K')
            return false;

        return true;
    }
}

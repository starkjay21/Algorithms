package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (char[] c: board) {
            Arrays.fill(c, '.');
        }
        List<char[][]> list = new ArrayList<>();
        System.out.println(queens(board, 0, list));
        for(char[][] arr: list){
            for (char[] chars : arr) {
                for (char aChar : chars) {
                    System.out.print(aChar + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    static int queens(char[][] board, int row, List<char[][]> list){
        if(row == board.length)
        {
            char[][] newBoard = new char[board.length][board.length];

            for (int i = 0 ; i < board.length ; i++)
                System.arraycopy(board[i], 0, newBoard[i], 0, board.length);

            list.add(newBoard);

            return 1;
        }

        int count = 0;
        for(int col = 0 ; col < board[row].length ; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                count += queens(board, row+1, list);
                board[row][col] = '.';
            }
        }
        return count;
    }

    private static void display(char[][] board) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isSafe(char[][] board, int row, int col){
        for(int i = 0 ; i <= row ; i++)
            if(board[i][col] == 'Q')
                return false;

        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i] == 'Q')
                return false;
        }

        int maxRight = Math.min(row, board[row].length - col - 1);
        for (int i = 1; i <= maxRight; i++)
            if(board[row-i][col+i] == 'Q')
                return false;

        return true;
    }
}

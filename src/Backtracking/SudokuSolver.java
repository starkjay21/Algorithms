package Backtracking;

public class SudokuSolver {
    static char[][] res;
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        };
        res = new char[9][9];
        solver(board, 0, 0);
        for (char[] chars : res) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
    static void solver(char[][] board, int row, int col){

        if(row == board.length-1 && col == board.length){
            for (int i = 0; i < 9; i++) {
                System.arraycopy(board[i], 0, res[i], 0, 9);
            }
            return;
        }
        if(col == board.length){
            solver(board, row+1, 0);
            return;
        }

        if(board[row][col] == '.'){
            for (int i = 1; i <= 9; i++) {
                if(isSafe(board, row, col, i)){
                    board[row][col] = (char)(i+'0');
                    solver(board, row, col+1);
                    board[row][col] = '.';
                }
            }
        } else {
            solver(board, row, col+1);
        }
    }

    static boolean isSafe(char[][] board, int row, int col, int val){
        char ch = (char)(val+'0');
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == ch)
                return false;
        }

        for (int i = 0; i < board.length; i++) {
            if(board[i][col] == ch)
                return false;
        }

        int boxRow = row/3;
        int boxCol = col/3;
        int rowStart = boxRow*3;
        int rowEnd = (boxRow+1)*3;
        int colStart = boxCol*3;
        int colEnd = (boxCol+1)*3;
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if(board[i][j] == ch)
                    return false;
            }
        }
        return true;
    }
}

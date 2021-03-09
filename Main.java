/**
 * Created by Debrup on 09-03-2021
 */



import java.util.*;

public class Main {
    private static int[][] ans = new int[9][9];

    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static int[][] store(int[][] board){

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                ans[i][j]=board[i][j] ;
            }
        }
        return ans;
    }

    public static void solveSudoku(int[][] board, int i, int j) {
        if (i == board.length){
            display(board);
            store(board);
            return;
        }

        int ni = 0;
        int nj = 0;

        if(j == board[0].length - 1){
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if(board[i][j] != 0){
            solveSudoku(board, ni, nj);
        } else {
            for(int val = 1; val <= 9; val++){
                if(isValid(board, i, j, val)){
                    board[i][j] = val;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static boolean isValid(int[][] board, int x, int y, int val) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if (board[x][i] == val) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[i][y] == val) {
                return false;
            }
        }

        x = x / 3 * 3;
        y = y / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[x + i][y + j] == val) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter your sudoku problem here ");
        System.out.println("Format (9x9) ");
        System.out.println(" 3 0 6 5 0 8 4 0 0 \n 5 2 0 0 0 0 0 0 0 \n 0 8 7 0 0 0 0 3 1 \n 0 0 3 0 1 0 0 8 0 \n 9 0 0 8 6 3 0 0 5 \n 0 5 0 0 9 0 6 0 0 \n 1 3 0 0 0 0 2 5 0 \n 0 0 0 0 0 0 0 7 4 \n 0 0 5 2 0 6 3 0 0  ");
        System.out.println("Now Enter Your Input like that ");
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        System.out.println("This is the ans for Testing purpose");



        solveSudoku(arr, 0, 0);



       //display(ans);

        System.out.println("Now Enter the ans values one by one and press enter ");
        System.out.println("For right input it will return true and for wrong input it will return false  ");

        int[][] arr1 = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr1[i][j] = scn.nextInt();
                if(arr1[i][j]== ans[i][j]){
                    System.out.println(true);
                }else{
                    System.out.println(false);

                }
            }
        }




    }
}


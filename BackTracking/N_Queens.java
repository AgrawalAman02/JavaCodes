package BackTracking;

import java.util.Scanner;

public class N_Queens {
    public static boolean isSafe(char[][] chessBoard, int rows,int cols){
        // for vertical up case
        for(int i= rows -1;i>=0;i--){
            if(chessBoard[i][cols]=='Q') return false;
        }

        // for virtucal left diagoal
        for(int i = rows-1,j=cols-1;i>=0&&j>=0 ;i--,j--){

                if(chessBoard[i][j]=='Q'){
                    return false;
                }

        }

        // for vertical right diagonal
        for(int i = rows -1,j=cols+1;i>=0&&j<chessBoard.length;i--,j++){
            if(chessBoard[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void printResult(char[][] chessBoard){
        System.out.println(".....................the chess board is....................");
        for(int i = 0 ; i<chessBoard.length;i++){
            for(int j= 0;j<chessBoard.length;j++){
                System.out.print(chessBoard[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void nQueens(char[][] chessBoard,int i){
        if(i==chessBoard.length){
            printResult(chessBoard);
            count++;
            return;
        }

        for(int j=0;j<chessBoard.length;j++){
            if (isSafe(chessBoard,i,j)){
                chessBoard[i][j] = 'Q';
                nQueens(chessBoard,i+1);
                chessBoard[i][j] = 'x';
            }

        }
    }
    static int count =0;
    public static void main(String[] args) {
        System.out.print("enter the no. of cols or rows of the chessbord: ");
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        char [][] chessBoard=new char[n][n];
        for (int i =0; i<chessBoard.length;i++){
            for (int j=0;j<chessBoard.length;j++){
                chessBoard[i][j]= 'x';
            }
        }
        nQueens(chessBoard,0);
        System.out.println("total ways : "+ count);
    }
}
// tc = n!
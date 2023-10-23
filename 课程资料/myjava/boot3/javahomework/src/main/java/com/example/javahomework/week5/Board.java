package com.example.javahomework.week5;

import java.util.ArrayList;
import java.util.List;

/**
 * @PACKAGE_NAME: com.example.javahomework.week5
 * @NAME: Board
 * @USER: jiang000
 * @DATE: 2023/10/9
 **/
public class Board {
    // private int size;
    // ⭕
    // ⚫
    // 🔴

    private char[][] board;

    public List<Integer> lastStep = new ArrayList<>();
    public void init(){
        board = new char[25][25];
        for(int i = 0; i < 22; i++) {
            char[] temp = new char[25];
            for (int j = 0; j < 25; j++) {
                if (j == 0) temp[0] = '|';
                else if (j == 1) {
                    if(i < 9) temp[1] = '0';
                    else if(i > 8 && i < 19) temp[1] = '1';
                    else temp[1] = '2';
                } else if (j == 2) {
                    if(i % 10 + 1 == 10) temp[2] = '0';
                    else  temp[2] = (char) (i % 10 + '1');
                } else temp[j] = '➕';
            }
            board[i] = temp;
        }
    }
    public Board(){
        board = new char[25][25];
        for(int i = 0; i < 22; i++) {
            char[] temp = new char[25];
            for (int j = 0; j < 25; j++) {
                if (j == 0) temp[0] = '|';
                else if (j == 1) {
                    if(i < 9) temp[1] = '0';
                    else if(i > 8 && i < 19) temp[1] = '1';
                    else temp[1] = '2';
                } else if (j == 2) {
                    if(i % 10 + 1 == 10) temp[2] = '0';
                    else  temp[2] = (char) (i % 10 + '1');
                } else temp[j] = '➕';
            }
            board[i] = temp;
        }
    }
    public void place(int row, int col, char data){
        board[row - 1][col + 2] = data;
    }
    public char getData(int row, int col){
        return board[row - 1][col + 2];
    }
    public boolean checkWin(int row, int col, char data){
        // TODO
        int count = 1;
        for (int i = 1; i < 5; i++) {
            if (col - i >= 1 && getData(row,col - i)  == data) {
                count++;
            } else {
                break;
            }
        }
        for (int i = 1; i < 5; i++) {
            if (col + i <= 22 && getData(row,col + i)  == data) {
                count++;
            } else {
                break;
            }
        }
        if (count >= 5) {
            return true;
        }

        // 检查垂直方向
        count = 1;
        for (int i = 1; i < 5; i++) {
            if (row - i >= 1 && getData(row - i,col)  == data) {
                count++;
            } else {
                break;
            }
        }
        for (int i = 1; i < 5; i++) {
            if (row + i <= 22 && getData(row + i,col) == data) {
                count++;
            } else {
                break;
            }
        }
        if (count >= 5) {
            return true;
        }

        // 检查主对角线方向
        count = 1;
        for (int i = 1; i < 5; i++) {
            if (row - i >= 1 && col - i >= 1 && getData(row - i,col - i)  == data) {
                count++;
            } else {
                break;
            }
        }
        for (int i = 1; i < 5; i++) {
            if (row + i <= 22 && col + i <= 22 && getData(row + i,col + i)  == data) {
                count++;
            } else {
                break;
            }
        }
        if (count >= 5) {
            return true;
        }

        // 检查副对角线方向
        count = 1;
        for (int i = 1; i < 5; i++) {
            if (row - i >= 1 && col + i <= 22 && getData(row - i,col + i)  == data) {
                count++;
            } else {
                break;
            }
        }
        for (int i = 1; i < 5; i++) {
            if (row + i <= 22 && col - i >= 1 &&
                    getData(row + i,col - i) == data) {
                count++;
            } else {
                break;
            }
        }
        return count >= 5;
    }
    public void printBoard2(){
        System.out.println("|  01   03   05   07  09   11   13  15   17   19   21  ");
        for(int i = 0; i < 22; i++){
            for(int j = 0; j < 25; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }


    }
    public void printBoard(){

        System.out.println("|  01   03   05   07  09   11   13  15   17   19   21  ");
        System.out.println("|01➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|02➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|03➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|04➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|05➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|06➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|07➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|08➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|09➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|10➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|11➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|12➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|13➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|14➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|15➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|16➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|17➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|18➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|19➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|20➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|21➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
        System.out.println("|22➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
    }

    public int getBoard(int x,int y){
        if(board[x][y+3]=='⚫')return 1;
        else if(board[x][y+3]=='⭕')return 2;
        else return 0;
    }

}

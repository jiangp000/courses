package com.example.javahomework.week5.strategy;

import com.example.javahomework.week5.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @PACKAGE_NAME: com.example.javahomework.week5.strategy
 * @NAME: MiddleMode
 * @USER: jiang000
 * @DATE: 2023/10/12
 **/
public class MiddleMode implements Strategy{
    @Override
    public List<Integer> getLocation(Scanner scanner, Board myboard, char currData) {
        List<Integer> res = new ArrayList<>();
        List<Integer> lastStep = myboard.lastStep;
        if(lastStep.isEmpty()){
            res.add(6);
            res.add(6);
            return res;
        }
        else{
            int row = lastStep.get(0);
            int col = lastStep.get(1);
            for(int i = 1; i <= 22; i++){
                if(isValidMove(row - i, col) && !isOccupied(myboard, row - i, col)){
                    res.add(row - i);
                    res.add(col);
                    return res;
                }
                if(isValidMove(row + i, col) && !isOccupied(myboard, row + i, col)){
                    res.add(row + i);
                    res.add(col);
                    return res;
                }
                if(isValidMove(row , col - i) && !isOccupied(myboard, row, col - i)){
                    res.add(row);
                    res.add(col - i);
                    return res;
                }
                if(isValidMove(row, col + i) && !isOccupied(myboard, row, col + i)){
                    res.add(row);
                    res.add(col + i);
                    return res;
                }

                if(isValidMove(row - i, col - i) && !isOccupied(myboard, row - i, col - i)){
                    res.add(row - i);
                    res.add(col - i);
                    return res;
                }
                if(isValidMove(row + i, col - i) && !isOccupied(myboard, row + i, col - i)){
                    res.add(row + i);
                    res.add(col - i);
                    return res;
                }
                if(isValidMove(row - i , col + i) && !isOccupied(myboard, row - i, col + i)){
                    res.add(row - i);
                    res.add(col + i);
                    return res;
                }
                if(isValidMove(row + i, col + i) && !isOccupied(myboard, row + i, col + i)){
                    res.add(row + i);
                    res.add(col + i);
                    return res;
                }
            }
            return res;

        }
    }
    private boolean isValidMove(int row, int col) {
        Boolean res = row >= 1 && row <= 22 && col >= 0 && col <= 22;
        if(false == res){
            System.out.println("出了边界");
        }
        return res;
    }


    // 判断当前位置是否有棋子了
    private boolean isOccupied( Board board, int row, int col) {
        Boolean res =  board.getData(row, col) != '➕';
        if(true == res){
            System.out.println("此位置已有棋子");
        }
        return res;
    }
}

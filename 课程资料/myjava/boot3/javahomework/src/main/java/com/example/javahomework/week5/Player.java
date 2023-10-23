package com.example.javahomework.week5;

import com.example.javahomework.week5.strategy.GamePlayer;

import java.util.Scanner;
import java.util.List;

/**
 * @PACKAGE_NAME: com.example.javahomework.week5
 * @NAME: Player
 * @USER: jiang000
 * @DATE: 2023/10/9
 **/
public class Player {
    private char data;
    private String name;

    private GamePlayer gamePlayer;

    public List<Integer> getLocation(Scanner scanner, Board myboard, char data){
        return gamePlayer.getLocation(scanner, myboard, data);
    }
    public Player(char color, GamePlayer gamePlayer){
        if (color == 'w'){
            this.data = '⭕';
            this.name = "白色方";
        }
        else{
            data = '⚫';
            this.name = "黑色方";
        }
        this.gamePlayer = gamePlayer;
    }
    public String getName(){
        return this.name;
    }
    public char getData(){
        return this.data;
    }
    public void makeMove(Board board, int row, int col, char data){
        board.place(row, col,data);
    }
}

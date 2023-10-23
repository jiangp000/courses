package com.example.javahomework.week5.strategy;

import com.example.javahomework.week5.Board;

import java.util.List;
import java.util.Scanner;

/**
 * @PACKAGE_NAME: com.example.javahomework.week5.strategy
 * @NAME: GamePlayer
 * @USER: jiang000
 * @DATE: 2023/10/13
 **/
public class GamePlayer {
    private Strategy strategy;
    public GamePlayer(Strategy strategy) {
        this.strategy = strategy;
    }
    public List<Integer> getLocation(Scanner scanner, Board myboard, char data){
        return strategy.getLocation(scanner, myboard, data);
    }
}

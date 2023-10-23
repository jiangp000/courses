package com.example.javahomework.week5;

import com.example.javahomework.week5.strategy.*;

import java.util.Scanner;
import java.util.function.BiPredicate;

/**
 * @PACKAGE_NAME: com.example.javahomework.week5
 * @NAME: main
 * @USER: jiang000
 * @DATE: 2023/10/9
 **/
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择模式：   0(人机对弈)     1(选手对弈)");
        int chooseMode = Integer.parseInt(scanner.nextLine());
        if(chooseMode == 0){
            System.out.println("请选择人机对弈难度：    0(Easy)    1(Middle)    2(Hard)");
            int mode = Integer.parseInt(scanner.nextLine());
            Strategy gameMode, userMode;
            if(mode == 0){
                gameMode = new EasyMode();
            }
            else if(mode == 1){
                gameMode = new MiddleMode();
            }
            else {
                gameMode = new HardMode();
            }
            userMode = new UserMode();
            System.out.println();
            System.out.println();
            GamePlayer gamePlayer1 = new GamePlayer(gameMode);
            GamePlayer gamePlayer2 = new GamePlayer(userMode);
            Game game = new Game('w',gamePlayer1, 'b', gamePlayer2);
            game.start(scanner);
        }
        else{
            Strategy userMode1 = new UserMode();
            Strategy userMode2 = new UserMode();
            GamePlayer gamePlayer1 = new GamePlayer(userMode1);
            GamePlayer gamePlayer2 = new GamePlayer(userMode2);
            Game game = new Game('w', gamePlayer1, 'b', gamePlayer2);
            game.start(scanner);
        }
        scanner.close();
        // 是双人 还是单人，如果是单人的话，你需要什么难度级别的？easy，middle，hard。
        // 可以支持多人下五子棋

        // 不同策略
    }
}

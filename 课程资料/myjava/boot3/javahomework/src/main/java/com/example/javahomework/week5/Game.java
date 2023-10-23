package com.example.javahomework.week5;

import com.example.javahomework.week5.strategy.GamePlayer;
import com.example.javahomework.week5.strategy.Strategy;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @PACKAGE_NAME: com.example.javahomework.week5
 * @NAME: Game
 * @USER: jiang000
 * @DATE: 2023/10/9
 **/
public class Game {
    // 0表示正在游戏
    // 1表示赢了
    // 2表示和棋
    private int status;
    // 现在已经走了多少有效步，如果棋盘上的所有棋格都下满了，那么就是和棋。
    private int step;
    // 棋盘
    private Board board;
    // 用户1
    private Player player1;
    // 用户2
    private Player player2;
    // 当前下棋的一方
    private Player currentPlayer;
    // 记录了下棋的历史
    private List<String> history = new ArrayList<>();
    private Date mydate;
    // 是否接着下棋，在一盘棋结束的时候使用到
    private int continueGame = 1;
    // 打印历史信息，包括每一步，谁下子到哪里
    public void printHistory(){
        for(int i = 0; i < history.size(); i++){
            System.out.println(i + " :" + history.get(i));
        }
    }
    // 初始化一局游戏
    public Game(char player1, GamePlayer s1, char player2, GamePlayer s2){
        this.status = 0;
        board = new Board();
        this.player1 = new Player(player1, s1);
        this.player2 = new Player(player2, s2);
        if(player1 == 'b'){
            currentPlayer = this.player1;
        }
        else{
            currentPlayer = this.player2;
        }
        board.printBoard2();
    }
    // 开始一局游戏
    public void start(Scanner scanner) {
        // 棋手下棋，写成不一样的两种形式，一种是人机，一种是自身输入。
        // 或者统一写成Player.action，对于普通人来说，是接受键盘的输入，对于人机来说，自己探索下棋的棋子
        // getXAndY,得到X 后者Y，之后再判断是否
        // 所以有两个不同的策略，得到棋子的不同，但是本质上是一种策略
        // 从键盘下棋，随便下棋，中等下棋，难下棋。
        while (continueGame == 1) {
            long date1 =System.currentTimeMillis();
            System.out.println("请输入x,y（黑棋先走）");
            while (status == 0) {
                List<Integer> nextStep = currentPlayer.getLocation(scanner, board, currentPlayer.getData());
                int row = nextStep.get(0), col = nextStep.get(1);
                if (isValidMove(row, col) && !isOccupied(row, col)) {
                    board.place(row, col, currentPlayer.getData());
                    board.lastStep.clear();;
                    board.lastStep.add(row);
                    board.lastStep.add(col);
                    this.step++;
                    System.out.println("------------------------------------------------------------------------");
                    String currStr = currentPlayer.getName() + ":  " + row + "行, " + col + "列";
                    history.add(currStr);
                    printHistory();
                    board.printBoard2();
                    if (board.checkWin(row, col, currentPlayer.getData())) {
                        System.out.println(currentPlayer.getName() + " wins!");
                        this.status = 1;
                    } else if (this.step == 22 * 22) {
                        board.printBoard();
                        System.out.println("It's a draw!");
                        this.status = 2;
                    } else {
                        currentPlayer = (currentPlayer == player1) ? player2 : player1;
                    }
                }
                else {
                    System.out.println("Invalid move. Try again.");
                }
            }
            long date2 = System.currentTimeMillis();
//            System.out.println("花费时间: " + date2);
            System.out.println("是否继续游戏: 1.继续   0.退出");
            continueGame = Integer.parseInt(scanner.nextLine());
            if(continueGame == 1){
               board.init();
               history.clear();
               this.status = 0;
               board.printBoard2();
            }
            else {
                System.out.println("结束游戏");
            }
        }
    }
    // 判断是否是有效的一步
    private boolean isValidMove(int row, int col) {
        Boolean res = row >= 1 && row <= 22 && col >= 1 && col <= 22;
        if(false == res){
            System.out.println("出了边界");
        }
        return res;
    }
    // 判断当前位置是否有棋子了
    private boolean isOccupied(int row, int col) {
        Boolean res =  board.getData(row, col) != '➕';
        if(true == res){
            System.out.println("此位置已有棋子");
        }
        return res;
    }

}

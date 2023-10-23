package com.example.javahomework.week5.strategy;

import com.example.javahomework.week5.Board;

import java.util.*;

/**
 * @PACKAGE_NAME: com.example.javahomework.week5.strategy
 * @NAME: HardMode
 * @USER: jiang000
 * @DATE: 2023/10/12
 **/
public class HardMode implements Strategy {
    @Override
    public List<Integer> getLocation(Scanner scanner, Board myboard, char data) {
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        int nowScore = 0, row1 = 0, row2 = 0;

        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 22; j++) {
                System.out.print(myboard.getBoard(i, j) + " ");
            }
            System.out.println(" ");
        }


        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 22; j++) {
                if (myboard.getBoard(i, j) == 0) {
                    int ss = getScore(i, j, myboard);
                    if (ss > nowScore) {
                        nowScore = ss;
                        row1 = i;
                        row2 = j;
                    }
                }

            }
        }

        result.add(row1 + 1);
        result.add(row2 + 1);
        System.out.println(row1 + " " + row2 + "   " + nowScore);
        return result;
    }

    private int getScore(int x, int y, Board myboard) {


        Map<String, Integer> map;
        map = new HashMap<>();
        map.put("010", 10);//活1
        map.put("020", 100);//活2
        map.put("030", 1000);//活3
        map.put("040", 10000);//活4
        map.put("01-1", 8);//眠1
        map.put("02-1", 90);//眠2
        map.put("03-1", 100);//眠3
        map.put("04-1", 10000);//眠4


        int X[] = {1, -1, 0, 0, -1, 1, -1, 1};
        int Y[] = {0, 0, 1, -1, -1, 1, 1, -1};
        int tmp_sum = 0;
        int bj = 0;
        int lastSum = 0;
        for (int i = 0; i < X.length; i++) {
            //2代表是己方的白字，1代表对方的黑子
            int tmp_x = x + X[i];
            int tmp_y = y + Y[i];
            int num_positive = 0, num_negative = 0;

            if (tmp_x < 0 || tmp_y < 0 || tmp_x > 21 || tmp_y > 21) continue;

            if (myboard.getBoard(tmp_x, tmp_y) == 2) {    //如果这个坐标为2，说明当前方向第一子为己方
                if (i % 2 == 0) bj = 2;
                int temp = 0;
                //一直循环知道后面的子与第一子颜色不同为止
                while (myboard.getBoard(tmp_x, tmp_y) == 2) {
                    num_positive++;
                    tmp_x += X[i];
                    tmp_y += Y[i];
                    if ((tmp_x < 22 && tmp_x >= 0) && (tmp_y >= 0 && tmp_y < 22)) {
                        temp = myboard.getBoard(tmp_x, tmp_y);
                    }//判断边界问题，不能超边界
                    else {
                        temp = 2;
                        break;
                    }
                }
                /*-2是初始化的值，如果temp没被改变过，说明没有超边界，就把最终结束的ans赋给temp*/
                if (temp == 2) {
                    //根据hashmap给最后的tmp_sum加权值
                    Integer value = map.get("0" + num_positive + "-1");
                    if (i % 2 == 0) lastSum = value;
                    if (value != null) {
                        if (i % 2 == 1 && bj == 2) value *= lastSum;
                        tmp_sum += value;
                    }
                } else {
                    Integer value = map.get("0" + num_positive + "0");
                    if (i % 2 == 0) lastSum = value;
                    if (value != null) {
                        if (i % 2 == 1 && bj == 2) value *= lastSum;
                        tmp_sum += value;
                    }
                }
                tmp_sum *= 1.2;
            }
            //这里讨论的是另一种情况，即遇上了对方黑子的情况
            else if (myboard.getBoard(tmp_x, tmp_y) == 1) {
                if (i % 2 == 0) bj = 1;
                int temp = 0;
                while (myboard.getBoard(tmp_x, tmp_y) == 1) {
                    num_negative++;
                    tmp_x += X[i];
                    tmp_y += Y[i];
                    if ((tmp_x < 14 && tmp_x >= 0) && (tmp_y >= 0 && tmp_y < 14)) {
                        temp = myboard.getBoard(tmp_x, tmp_y);
                    } else {
                        temp = 2;
                        break;
                    }
                }
                //如果遇上了白子而停止，执行以下操作
                if (temp == 2) {
                    Integer value = map.get("0" + num_negative + "-1");
                    if (i % 2 == 0) lastSum = value;
                    if (value != null) {
                        if (i % 2 == 1 && bj == 1) value *= lastSum;
                        tmp_sum += value;
                    }
                } else {
                    Integer value = map.get("0" + num_negative + "0");
                    if (i % 2 == 0) lastSum = value;
                    if (value != null) {
                        if (i % 2 == 1 && bj == 1) value *= lastSum;
                        tmp_sum += value;
                    }
                }
            }

            if (i % 2 == 1) {
                lastSum = 0;
                bj = 0;
            }
        }
        return tmp_sum;
    }

}


package com.example.javahomework.week5.strategy;

import com.example.javahomework.week5.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @PACKAGE_NAME: com.example.javahomework.week5.strategy
 * @NAME: EasyMode
 * @USER: jiang000
 * @DATE: 2023/10/12
 **/
public class EasyMode implements Strategy{
    @Override
    public List<Integer> getLocation(Scanner scanner, Board myboard, char data) {
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        int min = 1;
        int max = 22;
        // 生成 1 到 22 之间的随机整数
        for(int i = 0; i < 2; i++) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            result.add(randomNumber);
        }
        return result;
    }
}

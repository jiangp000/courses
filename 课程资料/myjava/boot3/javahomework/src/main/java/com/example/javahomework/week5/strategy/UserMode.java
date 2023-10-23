package com.example.javahomework.week5.strategy;

import com.example.javahomework.week5.Board;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * @PACKAGE_NAME: com.example.javahomework.week5.strategy
 * @NAME: CommonUser
 * @USER: jiang000
 * @DATE: 2023/10/12
 **/
public class UserMode implements Strategy{
    @Override
    public List<Integer> getLocation(Scanner scanner, Board myboard, char data) {
        String input = scanner.nextLine();
        // 使用逗号分隔符拆分输入字符串
        String[] numbers = input.split(",");
        int row = 0, col = 0;

        try {
            // 将拆分后的字符串转换为整数
            row = Integer.parseInt(numbers[0].trim());
            col = Integer.parseInt(numbers[1].trim());
        } catch (NumberFormatException e) {
            System.out.println("输入包含无效的数字。");
        }
        List<Integer> result = new ArrayList<>();
        result.add(row);
        result.add(col);
        return result;
    }
}

package com.example.javahomework.week5.strategy;

import com.example.javahomework.week5.Board;

import java.util.List;
import java.util.Scanner;


public interface Strategy {
    public List<Integer> getLocation(Scanner scanner, Board myboard, char data);

}

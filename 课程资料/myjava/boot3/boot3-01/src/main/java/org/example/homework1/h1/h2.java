package org.example.homework1.h1;

/**
 * @PACKAGE_NAME: org.example.homework1.h1
 * @NAME: h2
 * @USER: 潘江 2301210367
 * @DATE: 2023/9/22
 **/

//1. 每天都吃前一天剩下的一半多一个，到第十天想再吃时，只剩下一个桃子
//2. 第九天应该有4个，吃了一半，两个桃子，又多吃了一个，还剩下一个
//3 第八天应该有10个，吃了一半，五个桃子，又多吃了一个，还剩下四个
//4 所以第 i 天的桃子个数 A，和第i + 1 天的桃子个数B，关系是 A = 2（B + 1）
//5. 通过for循环，求出第一天的总个数，总个数 / 2 + 1即为第一天吃的个数


public class h2 {
    public static void main(String[] args) {
        int num = 1;
        for(int i = 0; i < 9; i++){
            num = 2 * (num + 1);
        }
        System.out.println("第一天一共吃了： " + (num / 2 + 1));

    }
}

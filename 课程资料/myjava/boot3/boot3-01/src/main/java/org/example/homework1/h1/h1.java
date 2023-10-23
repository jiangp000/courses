package org.example.homework1.h1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @PACKAGE_NAME: org.example.homework1.h1
 * @NAME: h1
 * @USER: 潘江 2301210367
 * @DATE: 2023/9/22
 **/

// 使用辗转相除法，求最大公因数，求得最大公因数后，两数相乘再除以最大公约数即可得到最小公倍数
// 其时间复杂度为 O(log(min(a, b)))，空间复杂度为 O(1)
// 题目中说给定任意两个正整数，若不是两个正整数，应该让用户重新输入。
// 题目中说对于任意的正整数，如果是对于在int范围内的数字，即可以用int来处理
// 如果数据范围超过int类型，使用BigInteger来处理一些大整数
public class h1 {

   //    使用辗转相除法求最大公因数，下面是数据范围在int内的实现。
    public static int gcd(int nums1, int nums2){
        while (nums2 > 0){
            int temp = nums1 % nums2;
            nums1 = nums2;
            nums2 = temp;
        }
        return nums1;
    }


    //   getGCDAndLcmWithInt 是计算int范围内最大公因数与最小公倍数的调用接口
    public static void getGCDAndLcmWithInt() {
        while (true) {
            System.out.println("请输入两个正整数：");
            Scanner scanner = new Scanner(System.in);
            int nums1 = scanner.nextInt();
            int nums2 = scanner.nextInt();
            if (nums1 <= 0 || nums2 <= 0) {
                System.out.println("输入数字不合法，请重新输入两个正整数");
                continue;
            }
            int res = gcd(nums1, nums2);
            System.out.println("最大公因数为： " + res);
            System.out.println("最小公倍数为：" + nums1 * nums2 / res);
        }
    }


    // 使用辗转相除法求最大公因数，下面是对于大整数的实现
    public static BigInteger gcd(BigInteger nums1, BigInteger nums2){
        while (nums2.compareTo(BigInteger.ZERO) > 0){
            BigInteger temp = nums1.mod(nums2);
            nums1 = nums2;
            nums2 = temp;
        }
        return nums1;
    }


    //   getGCDAndLcmWithBigNums 是计算大整数范围内最大公因数与最小公倍数的调用接口
    public static void getGCDAndLcmWithBigNums() {
        while (true) {
            System.out.println("请输入两个正整数：");
            Scanner scanner = new Scanner(System.in);
            BigInteger nums1 = scanner.nextBigInteger();
            BigInteger nums2 = scanner.nextBigInteger();
            // 如果输入的是负数，请重新输入
            if (nums1.compareTo(BigInteger.ZERO) < 0) {
                System.out.println("输入数字为负数，请重新输入两个正整数");
                continue;
            }
            BigInteger res = gcd(nums1, nums2);
            System.out.println("最大公因数为： " + res);
            System.out.println("最小公倍数为：" + (nums1.multiply(nums2).divide(res)));
        }
    }


    public static void main(String[] args){
        getGCDAndLcmWithBigNums();

    }

}

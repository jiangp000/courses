package com.example.javahomework.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.example.javahomework.week4
 * @NAME: 潘江
 * @USER: 2301210367
 * @DATE: 2023/10/6
 **/
public class h3 {
    // 组合问题，对于每一个数字都有多种的对应方式，将所有的对应方式展开。
    public void backtrack(List<String> res, Map<Character, String> mymap, String digits, int index, StringBuffer str ){
        if(digits.length() == index){
            res.add(str.toString());
            return;
        }
        char digit = digits.charAt(index);
        String phones = mymap.get(digit);
        for(int i = 0; i < phones.length(); i++){
            str.append(phones.charAt(i));
            backtrack(res, mymap, digits, index + 1, str);
            str.deleteCharAt(index);
        }
    }
    public  List<String> getAllResults(String digits){
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        // 创建一个不可变的map对象
        final Map<Character, String> mymap = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );
        StringBuffer temp = new StringBuffer();
        backtrack(res, mymap, digits, 0, temp);
        return res;
    }

    public static void main(String[] args) {
        h3 demo = new h3();
        String str1 = "2";
        String str2 = "23";
        String str3 = "234";
        String str4 = "";
        System.out.println(demo.getAllResults(str1));
        // 输出结果为  [a, b, c]
        System.out.println(demo.getAllResults(str2));
        // 输出结果为  [ad, ae, af, bd, be, bf, cd, ce, cf]
        System.out.println(demo.getAllResults(str3));
        // 输出结果为  [adg, adh, adi, aeg, aeh, aei, afg, afh, afi, bdg, bdh, bdi, beg, beh, bei, bfg, bfh, bfi, cdg, cdh, cdi, ceg, ceh, cei, cfg, cfh, cfi]
        System.out.println(demo.getAllResults(str4));
        // 输出结果为  []


    }
}

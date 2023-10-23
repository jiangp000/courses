package com.example.javahomework.week4;

/**
 * @PACKAGE_NAME: com.example.javahomework.week4
 * @NAME: 潘江
 * @USER: 2301210367
 * @DATE: 2023/10/6
 * @Time: O(n)
 * @Space: O(1)
 **/
public class h2 {
    public void reverse(char[] arr){
        // 使用双指针分别指向开始和末尾元素，每次互相交换并且移动前后指针，直到前后指针相遇反转结束。
        if(arr == null) return;
        for(int i = 0, j = arr.length - 1; i <= j; i++, j--){
            char temp =  arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return;
    }

    public static void main(String[] args) {
        h2 demo = new h2();
        char s1[] = {'1','2','3','a','4','b','d'};
        char s2[] = {};
        char s3[] = {'9','8','6','5','4','3','2','1','0'};
        demo.reverse(s1);
        System.out.println(s1);
        // 输入结果为  db4a321
        demo.reverse(s2);
        System.out.println(s2);
        // 输入结果为
        demo.reverse(s3);
        System.out.println(s3);
        // 输入结果为  012345689

    }
}

package org.example.homework1.h1;


/**
 * @PACKAGE_NAME: org.example.homework1.h1
 * @NAME: h4
 * @USER: 潘江 2301210367
 * @DATE: 2023/9/22
 **/

// 定义了图书类，具有成员变量书名，价格，以及编号和静态属性“总册数”
// 在构造图书类的时候，至少要给定图书名称，价格（可以没有）才能构造一个新书。


class Book{
    private String name;
    private static int count = 0;
    private double price;
    private int id;


    // 构造函数，包含书名 和 价格
    public Book(String name, float price) {
        this.name = name;
        this.price = price;
        this.id = count;         // count 为书本的编号
        this.count++;
    }

    // 构造函数，包含书名，没有价格
    public Book(String name) {
        this.name = name;
        this.price = -1;         // -1 表示暂时没有价格
        this.id = count;         // count 为书本的编号
        this.count++;
    }

    public int getCount(){
        return count;
    }

    // 获取该书的所有信息
    public String getinfo() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}

public class h4 {
    public static void main(String[] args) {

        Book book1 = new Book("Java",9);
        System.out.println("图书的总数量为： " + book1.getCount());

        Book book2 = new Book("Python",20);
        System.out.println("图书的总数量为： " + book2.getCount());

        Book book3 = new Book("C++",30);
        System.out.println("图书的总数量为： " + book3.getCount());

        Book book4 = new Book("PHP",40);
        System.out.println("图书的总数量为： " + book4.getCount());

        Book book5 = new Book("C#",50);
        System.out.println("图书的总数量为： " + book5.getCount());

        // 输出的信息分别为：1，2，3，4，5


    }

}

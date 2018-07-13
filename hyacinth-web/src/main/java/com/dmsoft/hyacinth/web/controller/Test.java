package com.dmsoft.hyacinth.web.controller;


import java.io.File;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        Txt staff=new Txt();
        Scanner in = new Scanner(System.in);
        staff.staff();
        System.out.print("输入TXT文本名称 (例如: D:/java.txt ):");
        String textFileName = in.nextLine();
        System.out.print("输入保存的图片名称 (例如： D:/java.jpg):");
        String imageFileName = in.nextLine();

        TextToImage convert = new TextToImage(new File(textFileName), new File(imageFileName));
        boolean success = convert.convert();
        System.out.println("文本转图片：" + (success ? "成功" : "失败"));
    }
}
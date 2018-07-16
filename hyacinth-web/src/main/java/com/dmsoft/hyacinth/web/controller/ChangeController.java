package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dto.SalaryDto;
import com.dmsoft.hyacinth.server.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
@RequestMapping(value = "/staff")
public class ChangeController {

    @Autowired
    private SalaryService salaryService;

    @ResponseBody
    @RequestMapping(value = "/package")
    public void findByCode(){
        SalaryDto salaryDto=salaryService.findbycode("DM12345");
        try {
            OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream("d:/test.txt"), "utf-8");
            outputStream.write(salaryDto.getString());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String textFileName = ("d:/test.txt");
        String imageFileName= ("d:/test.jpg");
        String ZipFileName= ("d:/test.zip");
        String password="123";
        TextToImageController convert = new TextToImageController(new File(textFileName), new File(imageFileName));
        boolean success = false;
        try {
            success = convert.convert();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文本转图片：" + (success ? "成功" : "失败"));
        PackageController p=new PackageController();
        p.zipFilesAndEncrypt(imageFileName,ZipFileName,password);
        //删除两个过程文件

        File f1 = new File("D:/test.txt");  // 输入要删除的文件位置
        if(f1.exists())
            f1.delete();

        File f2 = new File("D:/test.jpg");  // 输入要删除的文件位置
        if(f2.exists())
            f2.delete();
        HistoryController history=new HistoryController();
        history.packagehistory();
    }


}
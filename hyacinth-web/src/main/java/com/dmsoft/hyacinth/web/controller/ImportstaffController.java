package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.sql.SQLOutput;


@Controller
@RequestMapping(value="/import")
public class ImportstaffController {
    @Autowired
    private StaffService staffService;
    private StaffDto staff;
    @RequestMapping(value="/staff")
    public String importstaff(){
        BufferedReader bReader=null;
        try {
            File file = new File("C:\\Users\\soft\\Desktop\\员工信息模板.csv");
            bReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk"));
        }catch (FileNotFoundException e){e.printStackTrace();}
        catch (IOException r){}
        String line = "";
        try {
            bReader.readLine();
            staffService.deltetall();
            while ((line = bReader.readLine()) != "") {
                String[] pills = line.split(";");
                System.out.println(pills[0]);
                long id = Long.parseLong(pills[0]);
                System.out.println(id+pills[1]);
                staffService.insert(id, pills[1], pills[2], pills[3], pills[4], pills[5], pills[6], pills[7]);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            return "views/staff/staffs";
        }

//        return "views/staff/staffs";
    }
}

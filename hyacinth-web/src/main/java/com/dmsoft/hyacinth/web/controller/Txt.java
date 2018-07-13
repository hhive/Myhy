package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.entity.Staff;
import com.dmsoft.hyacinth.server.service.StaffService;
import com.dmsoft.hyacinth.server.service.impl.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.List;


import java.io.*;

/**
 * java读取数据库内容并存放到txt文件中
 *
 * @author young
 *
 */
@Controller
@RequestMapping(value = "/list")
public class Txt {

    @Autowired
    private StaffService staffService;
    private StaffDto staffDto=new StaffDto();

    public StaffDto staff() {
        return staffService.findByCode("DM10002");
         /*staffDto=staffService.findByCode("DM10002");
            try {
                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                ObjectOutputStream oo = new ObjectOutputStream(bo);
                oo.writeObject(staffDto);
                byte[] bytes = bo.toByteArray();
                FileOutputStream outputStream = new FileOutputStream(new File("d;/test.txt"));
                outputStream.write(bytes);
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }

}

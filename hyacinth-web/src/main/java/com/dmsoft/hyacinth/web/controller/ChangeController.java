package com.dmsoft.hyacinth.web.controller;


import com.dmsoft.hyacinth.server.dto.SalaryDto;
import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.service.EmailService;
import com.dmsoft.hyacinth.server.service.SalaryService;
import com.dmsoft.hyacinth.server.service.StaffService;
import com.dmsoft.hyacinth.web.controller.ExportImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.AuthenticationFailedException;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ChangeController {
    String isExport = null;

    @Autowired
    private StaffService staffService;
    @Autowired
    private SalaryService salaryService;
    @Autowired
    HistoryController historyController;
    @Autowired
    EmailService emailService;
    @RequestMapping(value = "/export")
    public String export(@RequestParam("id_checked")List<String> idList,HttpServletResponse response)throws IOException{
        //List<SalaryDto> salaryDtoList=salaryService.findAll();
           // SalaryDto sa = salaryService.findbycode("DM12345");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =response.getWriter();
        idList.forEach(id->{
           String code=staffService.findById(Long.parseLong(id)).getCode();
            SalaryDto sa = salaryService.findbycode(code);
            if(sa==null){
                throw new RuntimeException("未找到工号为"+code+"的工资");
               // out.print("<script language=\"javascript\">alert('未找到工号为"+code+"的工资');</script>");
            }
            else{
            exportImage(sa);
            PackageController packageController=new PackageController();
                packageController.zipFilesAndEncrypt("d:/"+sa.getName()+".bmp","d:/"+sa.getName()+".zip",sa.getCode());
                File file = new File("d:/"+sa.getName()+".bmp");
                file.delete();
            historyController.packagehistory(code);}});
        return "index";
    }

    @RequestMapping(value = "/email",method = RequestMethod.POST)
    public String email(@RequestParam("id_checked")List<String> idList){
        //SalaryDto sa = salaryService.findbycode("DM12345");
       // List<SalaryDto> salaryDtoList=salaryService.findAll();
        idList.forEach(id->{
            String code=staffService.findById(Long.parseLong(id)).getCode();
            SalaryDto sa = salaryService.findbycode(code);
           exportImage(sa);
        SendemailController s=new SendemailController();
        try {
            s.sendSalaryWithAttachment(sa.getName());
        }catch (NullPointerException e){
            throw new NullPointerException("未找到工号为"+code+"的工资文件");
        }
        historyController.sendhistory(code);});
        return "index";
    }

  private Boolean exportImage(SalaryDto sa){
        List<List<List<String>>> allValue = new ArrayList<>();
        List<String> content1 =Arrays.asList(new String[]{sa.getCode(),sa.getName()});
        List<String> content2 = Arrays.asList(new String[]{String.valueOf(sa.getBasic_salary()),String.valueOf(sa.getOvertime_wage()),String.valueOf(sa.getPost_allowance()),String.valueOf(sa.getPerformance_allowance()),String.valueOf(sa.getTotal_contract_wages()),String.valueOf(sa.getSeniority_allowance()),String.valueOf(sa.getMeal_allowance()),String.valueOf(sa.getOther_allowance()),String.valueOf(sa.getOther_pre_tax_buckle()),String.valueOf(sa.getTotal_payroll()),String.valueOf(sa.getReal_basic_salary()),String.valueOf(sa.getReal_overtime_allowance()),String.valueOf(sa.getReal_post_allowance()),String.valueOf(sa.getReal_performance_allwoance()),String.valueOf(sa.getSick_pay()),String.valueOf(sa.getGross_pay()),String.valueOf(sa.getSocial_security()),String.valueOf(sa.getHousing_fund()),String.valueOf(sa.getIncome_tax()),String.valueOf(sa.getHotel_expense()),String.valueOf(sa.getWater_electricity()),String.valueOf(sa.getMutual_fund()),String.valueOf(sa.getTelephone_fare()),String.valueOf(sa.getNetwor_fee()),String.valueOf(sa.getDeductions_after_tax()),String.valueOf(sa.getReal_salary()),String.valueOf(sa.getReal_allwoance())});
        List<String> content3 = Arrays.asList(new String[]{String.valueOf(sa.getTotal())});

        List<List<String>> contentArray1 = new ArrayList<>();
        contentArray1.add(content1);
        List<List<String>> contentArray2 = new ArrayList<>();
        contentArray2.add(content2);
        List<List<String>> contentArray3 = new ArrayList<>();
        contentArray3.add(content3);


        allValue.add(contentArray1);
        allValue.add(contentArray2);
        allValue.add(contentArray3);

        List<String[]> headTitles = new ArrayList<>();
        String[] h1 = new String[]{"工号","姓名"};
        String[] h2 = new String[]{"应发基本工资","应发周末固定加班工资","应发职位津贴","应发绩效津贴","合同工资总额","年资补贴","餐费补贴","其它补贴","税前其它扣补款","应发工资总额","实发基本工资","实发周末固定加班工资","实发职位津贴","实发绩效津贴","病假工资","税前工资总额","社保合计(个人)","住房公积金合计(个人)","个人收入所得税","住宿费","水电费","互助基金","套餐话费","网络费","税后其它补扣款合计","实发工资","实发奖金"};
        String[] h3= new String[]{"合计"};

        headTitles.add(h1);
        headTitles.add(h2);
        headTitles.add(h3);

        List<String> titles = new ArrayList<>();
        titles.add("工资条");
        titles.add("工资表");
        titles.add("");
        try {
            isExport = ExportImage.graphicsHtmlGeneration(allValue,titles,headTitles ,sa.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (isExport.equals(""))
                return false;
            else return true;
        }
    }
}

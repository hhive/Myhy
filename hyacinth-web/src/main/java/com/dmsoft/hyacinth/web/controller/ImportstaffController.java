package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dto.SalaryDto;
import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.entity.Salary;
import com.dmsoft.hyacinth.server.service.SalaryService;
import com.dmsoft.hyacinth.server.service.StaffService;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.sql.SQLOutput;


@Controller
@RequestMapping(value="/import")
public class ImportstaffController {
    @Autowired
    private StaffService staffService;
    private StaffDto staff;
    @Autowired
    private SalaryService salaryService;
    private SalaryDto salary=new SalaryDto();
    @RequestMapping(value="/staff",method = RequestMethod.POST)
    public String importstaff(@RequestParam("upfile") MultipartFile multfile){
        BufferedReader bReader=null;
        try {
            File file = null;
            try {
                file=File.createTempFile("tmp", null);
                multfile.transferTo(file);
                file.deleteOnExit();
            }catch (IOException e) {
                e.printStackTrace();
            }

            //CommonsMultipartFile cf = (CommonsMultipartFile)multfile;
            //这个myfile是MultipartFile的
           // DiskFileItem fi = (DiskFileItem) cf.getFileItem();
          //  File file = fi.getStoreLocation();
           // File file = new File("C:\\Users\\soft\\Desktop\\员工信息模板.csv");
            bReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk"));
        }catch (FileNotFoundException e){e.printStackTrace();}
        catch (IOException r){}
        String line = "";
        try {
            bReader.readLine();
            staffService.deltetall();
            while ((line = bReader.readLine()) != "") {
                System.out.print(line);
                String[] pills = line.split(";");
                long id = Long.parseLong(pills[0]);
                staffService.insert(id, pills[1], pills[2], pills[3], pills[4], pills[5], pills[6], pills[7]);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            return "views/staff/staffsearch";
        }
    }
    @RequestMapping(value = "salary",method = RequestMethod.POST)
    public String importsalary(@RequestParam("upfile2") MultipartFile multfile){

        BufferedReader bReader=null;
        long i=1;
        try {
            File file = null;
            try {
                file=File.createTempFile("tmp", null);
                multfile.transferTo(file);
                file.deleteOnExit();
            }catch (IOException e) {
                e.printStackTrace();
            }
            // File file = new File("C:\\Users\\soft\\Desktop\\薪资模板.csv");
            bReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk"));
        }catch (FileNotFoundException e){e.printStackTrace();}
        catch (IOException r){}
        String line = "";
        try {
            bReader.readLine();
           salaryService.deleteall();

            while ((line = bReader.readLine()) != "") {
                String[] pills = line.split(";");
                    /* salary.setCode(pills[0]);
                    salary.setName(pills[1]);
                    salary.setBasic_salary(Float.parseFloat(pills[2]));
                    salary.setOvertime_wage(Float.parseFloat(pills[3]));
                    salary.setPost_allowance(Float.parseFloat(pills[4]));
                    salary.setPerformance_allowance(Float.parseFloat(pills[5]));
                    salary.setTotal_contract_wages(Float.parseFloat(pills[6]));
                    salary.setSeniority_allowance(Float.parseFloat(pills[7]));
                    salary.setMeal_allowance(Float.parseFloat(pills[8]));
                    salary.setOther_allowance(Float.parseFloat(pills[9]));
                    salary.setOther_pre_tax_buckle(Float.parseFloat(pills[10]));
                    salary.setTotal_payroll(Float.parseFloat(pills[11]));
                    salary.setReal_basic_salary(Float.parseFloat(pills[12]));
                    salary.setReal_overtime_allowance(Float.parseFloat(pills[13]));
                    salary.setReal_post_allowance(Float.parseFloat(pills[14]));
                    salary.setReal_performance_allwoance(Float.parseFloat(pills[15]));
                    salary.setSick_pay(Float.parseFloat(pills[16]));
                    salary.setGross_pay(Float.parseFloat(pills[17]));
                    salary.setSocial_security(Float.parseFloat(pills[18]));
                    salary.setHousing_fund(Float.parseFloat(pills[19]));
                    salary.setIncome_tax(Float.parseFloat(pills[20]));
                    salary.setHotel_expense(Float.parseFloat(pills[21]));
                    salary.setWater_electricity(Float.parseFloat(pills[22]));
                    salary.setMutual_fund(Float.parseFloat(pills[23]));
                    salary.setTelephone_fare(Float.parseFloat(pills[24]));
                    salary.setNetwor_fee(Float.parseFloat(pills[25]));
                    salary.setDeductions_after_tax(Float.parseFloat(pills[26]));
                    salary.setReal_salary(Float.parseFloat(pills[27]));
                    salary.setReal_allwoance(Float.parseFloat(pills[28]));
                    salary.setTotal(Float.parseFloat(pills[29]));
                    salaryService.save(salary);*/
                salaryService.insert(i++,pills[0],pills[1],Float.parseFloat(pills[2]),Float.parseFloat(pills[3]),Float.parseFloat(pills[4]),Float.parseFloat(pills[5]),Float.parseFloat(pills[6])
                         ,Float.parseFloat(pills[7]),Float.parseFloat(pills[8]),Float.parseFloat(pills[9]),Float.parseFloat(pills[10]),Float.parseFloat(pills[11]),Float.parseFloat(pills[12]),Float.parseFloat(pills[13])
                         ,Float.parseFloat(pills[14]),Float.parseFloat(pills[15]),Float.parseFloat(pills[16]),Float.parseFloat(pills[17]),Float.parseFloat(pills[18])
                         ,Float.parseFloat(pills[19]),Float.parseFloat(pills[20]),Float.parseFloat(pills[21]),Float.parseFloat(pills[22]),Float.parseFloat(pills[23]),Float.parseFloat(pills[24])
                         ,Float.parseFloat(pills[25]),Float.parseFloat(pills[26]),Float.parseFloat(pills[27]),Float.parseFloat(pills[28])
                         ,Float.parseFloat(pills[29]));
               //for(int i=0;i<30;i++){
                 //  System.out.print(pills[i]+"\n");
              // }
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            return "views/staff/staffsearch";
        }
    }
}

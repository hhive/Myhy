package com.dmsoft.hyacinth.web.controller;

import java.util.List;

public class ExportTable {
    public static String getSingleImageHtml(String title, List<String> headTitle, List<List<String>> contentArray){
        //String html = "<!DOCTYPE html><html><body style=\"width:570px;\">";
        String html = "<table border=\"1\" style=\"border-collapse:collapse;width:1366px;border:1px solid black;background: white;\" cellpadding=\"0\" cellspacing=\"0\">";

        html+="<thead>";
        html+="<tr><th colspan=\""+headTitle.size()+"\" style=\"text-align: center;width: 570px;height:5px;font-size:"+("".equals(title)?"5px":"40px")+";\">"+title+"</th></tr>";
        html+="<tr>";
        for(int i = 0;i<headTitle.size();i++){
            String thEle = "";
            thEle = "<th style=\"height:30px;width:15%;text-align: center;margin:0;color: #000000 ;background:white;border:1px solid black;font-size: 15px;\">"+headTitle.get(i)+"</th>";
            html+=thEle;
        }
        html+="</tr>";
        html+="</thead>";
        html+="<tbody>";
        for(List<String> contents:contentArray){
            html+="<tr>";
            for(int j = 0;j<contents.size();j++){
                String tdEle = "";
                tdEle = "<td style=\"height:30px;width:16%;text-align: center;margin:0;border:1px solid black;font-size: 15px;color: #000000 ;background:white;\">"+contents.get(j)+"</td>";
                html+=tdEle;
            }
            html+="</tr>";
        }


        html+="</tbody>";
        html+="</table>";
        //html+="</body></html>";
        return html;
    }
}
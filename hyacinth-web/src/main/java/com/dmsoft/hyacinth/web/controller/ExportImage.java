package com.dmsoft.hyacinth.web.controller;
import com.dmsoft.hyacinth.web.controller.ExportTable;
import gui.ava.html.image.generator.HtmlImageGenerator;

import java.util.Arrays;
import java.util.List;

public class ExportImage {
    public static String graphicsHtmlGeneration(List<List<List<String>>> allValue, List<String> titles, List<String[]> headers , String receiver) throws Exception {
        int i = 0;
        String html = "";
        for(List<List<String>> list:allValue){
            String title = titles.get(i);
            List<String> headTitle = Arrays.asList(headers.get(i));
            html += ExportTable.getSingleImageHtml(title,headTitle,list);
            i++;
        }
        if(html != null && html.length()>0){
            HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
            imageGenerator.loadHtml(html);
            try {
                // Thread.sleep(5000);
                imageGenerator.getBufferedImage();
                //Thread.sleep(8000);
                String path = "d://"+receiver+".bmp";
                imageGenerator.saveAsImage(path);
                return path;
            } catch (Exception e) {
            }
        }
        return null;
    }
}


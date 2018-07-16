package com.dmsoft.hyacinth.web.controller;

import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;




import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class PackageController {

    public static void zipFilesAndEncrypt(String srcFileName, String zipFileName, String password) {
        ZipOutputStream outputStream = null;
        InputStream inputStream = null;
        if (StringUtils.isEmpty(srcFileName) || StringUtils.isEmpty(zipFileName)) {
            throw new NullArgumentException("待压缩文件或者压缩文件名");
        }
        try {
            File srcFile = new File(srcFileName);
            File[] files = new File[0];
            if (srcFile.isDirectory()) {
                files = srcFile.listFiles();
            } else {
                files = new File[1];
                files[0] = srcFile;
            }
            outputStream = new ZipOutputStream(new FileOutputStream(new File(zipFileName)));
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            if (!StringUtils.isEmpty(password)) {
                parameters.setEncryptFiles(true);
                parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
                parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
                parameters.setPassword(password);
            }


            int fileNums = files.length;
            for (int i = 0; i < fileNums; i++) {
                File file = (File) files[i];
                outputStream.putNextEntry(new ZipEntry(file.getName()));
                if (file.isDirectory()) {
                    outputStream.closeEntry();
                    continue;
                }

                inputStream = new FileInputStream(file);
                byte[] readBuff = new byte[4096];
                int readLen = -1;

                while ((readLen = inputStream.read(readBuff)) != -1) {
                    outputStream.write(readBuff, 0, readLen);
                }

                outputStream.closeEntry();
                inputStream.close();
            }

            outputStream.finish();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("文件压缩出错");
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.print("压缩文件输出错误");
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.print("压缩文件错误");
                }
            }
        }
    }
}

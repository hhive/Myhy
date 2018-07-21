package com.dmsoft.hyacinth.server.utils;

import com.dmsoft.hyacinth.server.dto.UserDto;
import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.UserService;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Component
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private String algorithmName = "md5";
    private final int hashIterations = 2;

    private static final String HEX_NUMS_STR="0123456789ABCDEF";
    private static final Integer SALT_LENGTH = 12;


    /**
     * 加密
     * @param user
     * @param pwd
     * @return
     */
    public String encryptPassword(User user,String pwd) {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        /*
         * MD5加密：
         * 使用SimpleHash类对原始密码进行加密。
         * 第一个参数代表使用MD5方式加密
         * 第二个参数为原始密码
         * 第三个参数为盐值，即用户名
         * 第四个参数为加密次数
         * 最后用toHex()方法将加密后的密码转成String
         * */
        String newPassword = new SimpleHash(
                algorithmName,
                pwd,
                ByteSource.Util.bytes(user.getSalt()+pwd),
                hashIterations).toHex();

        System.out.println(newPassword+"++++++++++++++++++++++++");
        return newPassword;

    }

    /**
     * 解密
     * @param user
     * @param getPwd
     * @return
     */
    public String decryptPassword(User user, String getPwd) {

       String dePassword=new SimpleHash(
               algorithmName,
               getPwd,
               ByteSource.Util.bytes(user.getSalt()+getPwd), //使用salt+password进行加密
               hashIterations
       ).toHex();

       System.out.println("****************"+dePassword);
        return dePassword;
    }
}

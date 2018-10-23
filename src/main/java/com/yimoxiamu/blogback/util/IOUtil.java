package com.yimoxiamu.blogback.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @ClassName IOUtile
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/10/23 15:00
 * @VERSION 1.0
 **/
public class IOUtil {

    /**
     * 图片转存本地并返回url地址
     * @param img
     * @return
     */
    public static  String saveImg(MultipartFile img,String flodPath){
        try {
            File floder = new File(flodPath);
            if(!floder.exists()){
                floder.mkdir();
            }
            String filePath = flodPath+"\\"+img.getOriginalFilename();
            img.transferTo(new File(filePath));
            return filePath;
        }catch (Exception e){
            return null;
        }
    }
}

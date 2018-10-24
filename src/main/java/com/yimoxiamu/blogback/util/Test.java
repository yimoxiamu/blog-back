package com.yimoxiamu.blogback.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    private static final Logger log = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        List list =new ArrayList();
        list.add("1");
        list.add("2");
        String []counts = {"123","456"};
        list.forEach((count) -> log.info(""+count));
        Arrays.sort(counts,(String i,String m)->(i.compareTo(m)));
        System.out.println(counts[1]);
    }
}

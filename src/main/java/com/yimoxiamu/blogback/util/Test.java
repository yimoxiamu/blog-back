package com.yimoxiamu.blogback.util;

import factory.Log;
import factory.LogFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    private static final Log log = LogFactory.getLog(Test.class);
    public static void main(String[] args) {
        List list =new ArrayList();
        list.add("1");
        list.add("2");
        String []counts = {"123","456"};
        list.forEach((count) -> log.info(count));
        Arrays.sort(counts,(String i,String m)->(i.compareTo(m)));
        System.out.println(counts[1]);
    }
}

package com.woc.bms.util.test;

import com.woc.bms.util.AppUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class AppUtilTest {


    @Test
    public void generateRandomNumber(){
        long i = AppUtil.generateRandomNumber();
        System.out.println(i);
        Assert.assertTrue(i>0);
    }


}

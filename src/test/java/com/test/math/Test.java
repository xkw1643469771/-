package com.test.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(BigDecimal.valueOf(1).divide(BigDecimal.valueOf(3),2, BigDecimal.ROUND_UP));
    }

}

package com.revanth.app;

import org.junit.Test;

public class MyCalculatorTest {
    @Test
    public void testAdd(){
        MyCalculator calc=new MyCalculator();
        double result=calc.add(2,5);
        assert result==7;
    }

    @Test
    public void testsub(){
        MyCalculator calc=new MyCalculator();
        double result=calc.sub(10,4);
        assert result==6;
    }

    @Test
    public void testdiv(){
        MyCalculator calc=new MyCalculator();
        double result=calc.div(25,5);
        assert result==5;
    }

    @Test
    public void tsetMultiply(){
        MyCalculator calc=new MyCalculator();
        double result=calc.multiply(12,12);
        assert result==144;
    }
}


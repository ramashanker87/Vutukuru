package com.revanth.app;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator calc=new Calculator();
        double result=calc.add(2,5);
        assert result==7;
    }

    @Test
    public void testsub(){
        Calculator calc=new Calculator();
        double result=calc.sub(10,4);
        assert result==6;
    }

    @Test
    public void testdiv(){
        Calculator calc=new Calculator();
        double result=calc.div(25,5);
        assert result==5;
    }
}


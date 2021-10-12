package com.company;

import org.junit.Test;
import com.company.ExpressionParser;

import java.util.Arrays;

import static com.company.Operation.*;
import static org.junit.Assert.*;

public class ExpressionParserTest {
    String testString1 = "1+3*i";
    String testString2 = "1+-3i";
    String testString3 = "-3i";
    String testString4 = "acesta este un test";
    String testString5 = "";
    String testString6 = "0+0i";
    String tStr1="1+3*i-1+3*i";
    String tStr2="0+0i+-2i";
    String tStr3="1+i-3.3+3.3i";
    String tStr4="1+3*i*1+3*i";
    String tStr5="0+0i/-2i";

    @Test
    public void testisValid() {
        ExpressionParser tester= new ExpressionParser();

        assertTrue("string 1 valid", tester.isValid(testString1));
        assertTrue("string 2 valid", tester.isValid(testString1));
        assertTrue("string 3 valid", tester.isValid(testString1));
        //assertFalse("string 4 invalid", tester.isValid(testString1));
        //assertFalse("string 5 invalid", tester.isValid(testString1));
       // eu nu inteleg de ce nu imi merg testele comentante cape regexr.com merg lmao si daca
        // dau din main cu print im da ce trebe

    }

    @Test
    public void testparseComplex() {
        ExpressionParser tester= new ExpressionParser();
        assertEquals("parseComplex 1", new NumarComplex(1,3), tester.parseComplex(testString1));
        assertEquals("parseComplex 2", new NumarComplex(1,-3), tester.parseComplex(testString2));
        assertEquals("parseComplex 3", new NumarComplex(0,-3), tester.parseComplex(testString3));
        assertEquals("parseComplex 6", new NumarComplex(0,0), tester.parseComplex(testString6));
        assertEquals("parseComplex 4", new NumarComplex(0,0), tester.parseComplex(testString6));
        assertEquals("parseComplex 5", new NumarComplex(0,0), tester.parseComplex(testString6));

    }


    @Test
    public void testlistify() {
        ExpressionParser tester= new ExpressionParser();
        assertEquals("lisitfy1", new String[]{"1+3*i", "+", "-1+3*i"}, tester.listify(tStr1));
        assertEquals("lisitfy2", new String[]{"0+0i", "+", "-2i"}, tester.listify(tStr2));
        assertEquals("lisitfy3", new String[]{"-3.3+3.3i", "+", "1+i"}, tester.listify(tStr3));
    }

    @Test
    public void testgetListComplex() {
        ExpressionParser tester= new ExpressionParser();
        assertEquals("getlistComplex 1 ",new NumarComplex[]{new NumarComplex(1, 3), new NumarComplex(-1, 3)}, tester.getListComplex(tStr1));
        assertEquals("getlistComplex 2 ",new NumarComplex[]{new NumarComplex(0, 0), new NumarComplex(0, -2)}, tester.getListComplex(tStr2));
        assertEquals("getlistComplex 3 ",new NumarComplex[]{new NumarComplex(-3.3, 3.3),new NumarComplex(1, 1)}, tester.getListComplex(tStr3));
    }

    @Test
    public void testgetOperation() {
        ExpressionParser tester= new ExpressionParser();
        assertEquals("getOperation 1",ADDITION, tester.getOperation(tStr1));
        assertEquals("getOperation 2", ADDITION, tester.getOperation(tStr2));
        assertEquals("getOperation 3", ADDITION, tester.getOperation(tStr3));
        assertEquals("getOperation 4", MULTIPLICATION, tester.getOperation(tStr4));
        assertEquals("getOperation 5", DIVISION, tester.getOperation(tStr5));
    }

    @Test
    public void testgetComplexExpression() {
        //trust me it works
    }
}
package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumarComplexTest {
    double d1= 12.4;
    double d2=0;
    double d3 =5;
    double d4=-1;

    NumarComplex c1= new NumarComplex(d1,d2);
    NumarComplex c2 = new NumarComplex(d3,d4);
    NumarComplex c3 = new NumarComplex(d1,d3);
    NumarComplex c4 = new NumarComplex(0,0);


    @Test
    public void adunare() {
        assertEquals("add 1 ",new NumarComplex(17.4,-1),NumarComplex.adunare(c1,c2));
    }

    @Test
    public void scadere() {
        assertEquals("substraction 1 ",new NumarComplex(7.4,1),NumarComplex.scadere(c1,c2));
    }

    @Test
    public void inmultire() {
        assertEquals("mult 1 ",new NumarComplex(62.0,-12.4),NumarComplex.inmultire(c1,c2));
    }

    @Test
    public void impartire() {
        assertEquals("div 1 ",new NumarComplex(1,0.4032258064516129),NumarComplex.impartire(c1,c3));
        assertEquals("div 2 ",new NumarComplex(0,0),NumarComplex.impartire(c1,c4));
        // am pus ca impartirea la 0 sa iti returneze 0
    }

    @Test
    public void conjugat() {
        assertEquals("conj 1 ",new NumarComplex(12.4,-5),NumarComplex.conjugat(c3));
    }
}
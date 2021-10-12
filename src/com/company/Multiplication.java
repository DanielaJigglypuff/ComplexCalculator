package com.company;

public class Multiplication extends ComplexExpression{
    Multiplication(NumarComplex[] args){
        this.operation=Operation.MULTIPLICATION;
        this.args = args;
    }
    @Override
    public NumarComplex executeOneOperation(NumarComplex c1, NumarComplex c2) {
        return NumarComplex.inmultire(c1,c2);
    }
}

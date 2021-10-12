package com.company;

public class Subtraction extends ComplexExpression{
    Subtraction(NumarComplex[] args){
        this.operation=Operation.SUBTRACTION;
        this.args = args;
    }
    @Override
    public NumarComplex executeOneOperation(NumarComplex c1, NumarComplex c2) {
        return NumarComplex.scadere(c1,c2);
    }
}

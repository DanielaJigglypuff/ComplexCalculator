package com.company;

public class Addition extends ComplexExpression{
    Addition(NumarComplex[] args){
        this.operation=Operation.ADDITION;
        this.args = args;
    }
    @Override
    public NumarComplex executeOneOperation(NumarComplex c1, NumarComplex c2) {
        return NumarComplex.adunare(c1,c2);
    }
}

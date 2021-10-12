package com.company;

public class Division extends ComplexExpression{
    Division(NumarComplex[] args){
        this.operation=Operation.DIVISION;
        this.args = args;
    }
    @Override
    public NumarComplex executeOneOperation(NumarComplex c1, NumarComplex c2) {
        return NumarComplex.impartire(c1,c2);
    }
}

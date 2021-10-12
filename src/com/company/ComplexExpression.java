package com.company;

import java.util.Arrays;

abstract class ComplexExpression {
    protected Operation operation;
    protected NumarComplex[] args;

    public abstract NumarComplex executeOneOperation(NumarComplex c1, NumarComplex c2);

    /**
     * Voiam sa mai testez functia si aveam nevoie de o metoda de a da print la expresia complexa
     * @return
     */
    @Override
    public String toString() {
        return "ComplexExpression{" +
                "operation=" + operation +
                ", args=" + Arrays.toString(args) +
                '}';
    }

    final NumarComplex execute() {
        NumarComplex result = new NumarComplex(0,0);
        try {
            result = args[0];
            for (int i = 1; i < args.length; i++)
                result = executeOneOperation(result, args[i]);
            return result;
        } catch (NullPointerException e) {
        }
        return result;
    }
}

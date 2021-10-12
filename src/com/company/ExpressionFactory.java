package com.company;

public class ExpressionFactory {
    static ExpressionFactory instance = new ExpressionFactory();
    private ExpressionFactory() {}

    public ComplexExpression createExpression(Operation operation, NumarComplex[] args){

        switch (operation){
            case ADDITION -> {
                return new Addition(args);
            }
            case SUBTRACTION -> {
                return new Subtraction(args);
            }
            case MULTIPLICATION -> {
                return new Multiplication(args);
            }
            case DIVISION -> {
                return new Division(args);
            }
        }
        return null;
    }
    public static ExpressionFactory getInstance() {
        return instance;
    }

}

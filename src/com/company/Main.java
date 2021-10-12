package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String divider = "───── ⋆⋅☆⋅⋆ ─────";

    public static String tastare() {
        /**
         * Primeste inputul utilizatorului
         */
        System.out.println(divider);
        System.out.println("Type here: ");
        Scanner scanner = new Scanner(System.in);
        String inputS = scanner.nextLine();
        String regex = "[a-h][j-w][yz]";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputS);
        boolean matchFound = matcher.find();
        if (inputS.isEmpty()) {
            System.out.println("U forgot something ? ");
            System.out.println(ExpressionParser.sans);
        } else if (matchFound) {
            System.out.println("bad input");
        } else {
            System.out.print(inputS + " = ");
        }
        return inputS;
    }

    public static void voila(String inputS) {
        /**
         * Voila arata rezultatul calculului
         */
        try {
            ComplexExpression exp = Objects.requireNonNull(ExpressionParser.getComplexExpression(inputS));
            NumarComplex rezult = exp.execute();
            System.out.println(rezult + "\n");
            System.out.println(divider);

        } catch (Exception exception) {
            System.out.println("(╭ರ_•́)");
            System.out.println(divider);
        }
    }

    public static void main(String[] args) {
        System.out.println(divider);
        System.out.println(Arrays.toString(args));
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < args.length; i++) {
            sb.append(args[i]);
        }

        String rez = sb.toString().replaceAll(",","");
        System.out.print("expresia data este "+rez+" = ");
        voila(rez);

        //daca doriti inputul de la tastatura
        voila(tastare());



    }
}





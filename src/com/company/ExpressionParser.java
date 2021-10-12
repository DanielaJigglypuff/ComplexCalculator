package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExpressionParser {
    /**
     *
     * @param c = stringul initial
     * @return true daca e valid si false daca nu e valid
     */
    public static boolean isValid(String c) {
        String regex = "((i)|(\\d+(\\.\\d+)?)|((\\d+(\\.\\d+)?)\\*i)|((\\d+(\\.\\d+)?)i)|((\\d+(\\.\\d+)?)(|\\+|-|\\+-)(\\d+(\\.\\d+)?)\\*i)|((\\d+(\\.\\d+)?)(|\\+|-|\\+-)(\\d+(\\.\\d+)?)i))";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(c);
        boolean matchFound = matcher.find();
        if(!matchFound) {return false;}
        else {return true;}
    }


    /**
     *
     * @param ex- stringul valid de numar complex
     * @return un objiect de tipul numarului complex
     */
    public static NumarComplex parseComplex(String ex) {
        NumarComplex parsed = new NumarComplex(0,0);
        if(isValid(ex)){
            String re="";
            String im="";
            ex = ex.replaceAll(" ", "");
            ex = ex.replaceAll("[\\*]", "");
            String regex0="(-?)(|\\+|\\-|)(i)"; //+-i (3)
            String regex1="(-?)(\\d+(\\.\\d+)?)";//a (4)
            String regex2="((-?)(\\d+(\\.\\d+)?)i)";//bi (2)
            String regex3="(\\d+(\\.\\d+)?)(|\\+|\\-|\\+-)(\\d+(\\.\\d+)?)i";//a+ -sau+-bi (0)
            String regex4="(-?)(\\d+(\\.\\d+)?)(\\+|\\-)(|\\-)i";//a+ -sau+-i (1)
            String[] regex={regex0,regex1,regex2,regex3,regex4};
            Pattern[] patterns= new Pattern[5];
            for (int i = 0; i < 5; i++){
                patterns[i]=Pattern.compile(regex[i], Pattern.CASE_INSENSITIVE);
            }

            if (patterns[3].matcher(ex).find()) {
                String ex3 = ex.replaceAll("i", "");
                if (ex3.indexOf('+') > 0) {
                    re = ex3.substring(0, ex.indexOf('+'));
                    im = ex3.substring(ex3.indexOf('+') + 1, ex3.length());
                    parsed = new NumarComplex(Double.parseDouble(re), Double.parseDouble(im));

                } else if (ex3.lastIndexOf('-') > 0) {
                    re = ex3.substring(0, ex3.lastIndexOf('-'));
                    im = ex3.substring(ex3.lastIndexOf('-') + 1, ex3.length());
                    parsed = new NumarComplex(Double.parseDouble(re), -Double.parseDouble(im));
                }
                else {
                    re = "0";
                    im = ex3;
                    parsed = new NumarComplex(Double.parseDouble(re), Double.parseDouble(im));
                }

            }
            else if((patterns[4].matcher(ex).find())){
                String ex4 = ex.replaceAll("i","");
                if(ex4.indexOf('+') > 0)
                {
                    re = ex4.substring(0,ex4.lastIndexOf('+'));
                    im="1";
                    parsed = new NumarComplex(Double.parseDouble(re),Double.parseDouble(im));
                }
                else if(ex4.lastIndexOf('-') > 0)
                {
                    re = ex4.substring(0,ex4.lastIndexOf('-'));
                    im="1";
                    parsed = new NumarComplex(Double.parseDouble(re),-Double.parseDouble(im));

                }


            }
            else if(patterns[2].matcher(ex).find()) {
                String ex2=ex.replaceAll("i", "");
                if (ex2.contains("-")) {
                    re = "0";
                    im = ex2;
                    parsed = new NumarComplex(Double.parseDouble(re), Double.parseDouble(im));
                }
                else {
                    re = "0";
                    im = ex2;
                    parsed = new NumarComplex(Double.parseDouble(re), Double.parseDouble(im));
                }

            }
            else if (patterns[0].matcher(ex).find()) {
                if (ex.charAt(0) == '-') {parsed = new NumarComplex(0, -1);}
                else {parsed = new NumarComplex(0, 1);}
            }
            else if(patterns[1].matcher(ex).find()){

                re=ex;
                parsed = new NumarComplex(Double.parseDouble(re), 0);
            }
            }
        return parsed;

    }

    /**
     * Scoate elementele nule dintr un array de objecte de tipul numerelor complexe
     * @param args
     * @return array ul fara nule si cu dimensiunea schimbata
     */
    public static NumarComplex[] removenullComplex(NumarComplex[] args){
        List<NumarComplex> listaC = new ArrayList<NumarComplex>(Arrays.asList(args));
        while (listaC.remove(null));
        NumarComplex[] rez = new NumarComplex[listaC.size()];
        listaC.toArray(rez);
        return rez;
    }

    /**
     * Scoate elementele nule dintr un array de stringuri
     * @param args
     * @return array ul fara elemente nule si cu dimensiune schimbata
     */
    public static String[] removenullString(String[] args){
        List<String> listaC = new ArrayList<String>(Arrays.asList(args));
        while (listaC.remove(null));
        String[] rez = new String[listaC.size()];
        listaC.toArray(rez);
        return rez;
    }

static String sans="█████████████▀▀▀▀▀▀▀▀▀▀▀▀▀███████████\n" +
                   "████████▀▀░░░░░░░░░░░░░░░░░░░▀▀██████\n" +
                   "██████▀░░░░░░░░░░░░░░░░░░░░░░░░░▀████\n" +
                   "█████░░░░░░░░░░░░░░░░░░░░░░░░░░░░░███\n" +
                   "████░░░░░▄▄▄▄▄▄▄░░░░░░░░▄▄▄▄▄▄░░░░░██\n" +
                   "████░░▄██████████░░░░░░██▀░░░▀██▄░░██\n" +
                   "████░░███████████░░░░░░█▄░░▀░░▄██░░██\n" +
                   "█████░░▀▀███████░░░██░░░██▄▄▄█▀▀░░███\n" +
                   "██████░░░░░░▄▄▀░░░████░░░▀▄▄░░░░░████\n" +
                   "█████░░░░░█▄░░░░░░▀▀▀▀░░░░░░░█▄░░░███\n" +
                   "█████░░░▀▀█░█▀▄▄▄▄▄▄▄▄▄▄▄▄▄▀██▀▀░░███\n" +
                   "██████░░░░░▀█▄░░█░░█░░░█░░█▄▀░░░░██▀▀\n" +
                   "▀░░░▀██▄░░░░░░▀▀█▄▄█▄▄▄█▄▀▀░░░░▄█▀░░░\n" +
                   "▄▄▄░░░▀▀██▄▄▄▄░░░░░░░░░░░░▄▄▄███░░░▄█\n" +
                   "██████▄▄░░▀█████▀█████▀██████▀▀░░▄███\n" +
                   "██████████▄░░▀▀█▄░░░░░▄██▀▀▀░▄▄▄███▀▄\n" +
                   "███████████░██░▄██▄▄▄▄█▄░▄░████████░█";

    /**
     * tranforma dintr un string in lista de objecte de tipul numerelor complexe si semnul folosind regex
     *va intrebati de ce am semnul pe pozitia 1 a listei
     * well functia asta era complet diferita pana mi-am dat seama ca ea crapa undeva
     * si ca sa nu schimb si get operation am facut sa fie bine :)
     * @param input
     * @return lista de nr complexe si semnul
     */
    public static String[] listify(String input) {

        String regex0 = "(-?)(\\d+(\\.\\d+)?)(|\\+|\\-|\\+-)(\\d+(\\.\\d+)?(\\*?))i";//a+ -sau+-b(*?)i (0)
        String regex1="(-?)(\\d+(\\.\\d+)?)(\\+|\\-)(|\\-)i";//a+ -sau+-i (1)
        String regex2="(-?)(\\d+(\\.\\d+)?)(\\*?)i";//b(*?)i (2)
        String regex3="(|\\+|\\-|)(i)"; //+-i (3)
        String regex4="(-?)(\\d+(\\.\\d+)?)";//a (4)

        List<String> l = new ArrayList<String>();
        // nu am stiut cum sa nu dau copy paste (inputul care e in perpetua schimbare m a incurcat teribil)
        //asa ca am zis sa fac "babeste"
        Matcher m0 = Pattern.compile(regex0).matcher(input);
        while (m0.find()) {l.add(m0.group());;}
        String input0 = input.replaceAll(regex0, "");

        Matcher m1 = Pattern.compile(regex1).matcher(input0);
        while (m1.find()) {l.add(m1.group());}
        String input1 = input0.replaceAll(regex1, "");

        Matcher m2 = Pattern.compile(regex2).matcher(input1);
        while (m2.find()) {l.add(m2.group());}
        String input2 = input1.replaceAll(regex2, "");

        Matcher m3 = Pattern.compile(regex3).matcher(input2);
        while (m3.find()) {l.add(m3.group());}
        String input3 = input2.replaceAll(regex3, "");

        Matcher m4 = Pattern.compile(regex4).matcher(input3);
        while (m4.find()) {l.add(m4.group());}
        String input4 = input3.replaceAll(regex4, "");

        if(input4.isEmpty()){l.add(1,"+");}
        else{l.add(1,Character.toString(input4.charAt(0)));}

        String[] Arrayfin = new String[l.size()];
        l.toArray(Arrayfin);

        return Arrayfin;
    }

    /**
     * ia doar numerele complexe din lista de numere complexe+semn
     * mda... am schimbar in arraylist ca sa pot scoate semnul then am facut un arraT temporar sa pot apela
     * functia parseComplex then am adaugat rezultatul la un aray list pe care, in final
     * l am convertit intr un array
     * @param args
     * @return o lista de numere complexe
     */
    public static NumarComplex[] getListComplex(String args) {
        String[] lst = listify(args);
        ArrayList<String> lstT = new ArrayList<>(Arrays.asList(lst));
        lstT.remove(1);//scoate semnul de pe pozitia lui
        ArrayList<NumarComplex> lstC= new ArrayList<>();
        int a=lstT.size();
        String[] arrT = new String[a];
        lstT.toArray(arrT);
        for (int i=0;i< arrT.length;i++ ){
            lstC.add(ExpressionParser.parseComplex(arrT[i]));
        }
        NumarComplex[] arrC = new NumarComplex[a];
        lstC.toArray(arrC);
        return arrC;
    }

    /**
     * ne da operatie care trebuie efectuata
     * @param args
     * @return
     */
    public static Operation getOperation(String args) {
        String[] lst = listify(args);
        String sign = lst[1];
        Operation operation = switch (sign) {
            case ("+") -> Operation.ADDITION;
            case ("-") -> Operation.SUBTRACTION;
            case ("/") -> Operation.DIVISION;
            case ("*") -> Operation.MULTIPLICATION;
            default -> throw new IllegalStateException("Unexpected value: " + sign);
        };
        return operation;
    }

    /**
     * transforma din string ul initial in obiect de tip Complex Expression
     * @param args
     * @return
     */
    public static ComplexExpression getComplexExpression(String args){
        Operation operation = getOperation(args);
        NumarComplex[] nrc = getListComplex(args);
        return ExpressionFactory.getInstance().createExpression(operation,nrc);
        }
}








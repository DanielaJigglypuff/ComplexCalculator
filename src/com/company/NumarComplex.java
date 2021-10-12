package com.company;

class NumarComplex {

    private double re, im;


    /*
    Constructorul (construieste un obiect nou de tipul numar complex)
     */
    public NumarComplex(double re, double im){
        this.re=re;
        this.im=im;
    }


    /*
    "getter" Returneaza partea reala a unui numar complex
     */
    public double real(){return re;}

    /*
    "getter" Returneaza partea imaginara a unui numar complex
    */
    public double imaginary(){return  im;}

    /**
     *aveam nevoie pentru teste
     */
    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof NumarComplex)) {
            return false;
        }
        // typecast o to Complex so that we can compare data members
        NumarComplex c = (NumarComplex) o;

        // Compare the data members and return accordingly
        return Double.compare(re, c.re) == 0
                && Double.compare(im, c.im) == 0;
    }


    @Override
    public String toString()
    {
        String temp = "" ;
        if ( im > 0 ) {
            temp = re + " + " + im + "*i";
        }else if ( im < 0 ) {
            temp = re + " + (" + im + "*i)";
        }
        else if ( im == 0 ) {
            temp = re +"";
        }
        return temp;
    }


    public static NumarComplex adunare(NumarComplex c1, NumarComplex c2){
        NumarComplex tmp = new NumarComplex (0,0);
        tmp.re = c1.re + c2.re;
        tmp.im = c1.im + c2.im ;
        return tmp;
    }


    public static NumarComplex scadere(NumarComplex c1, NumarComplex c2){
        NumarComplex tmp = new NumarComplex (0,0);
        tmp.re = c1.re - c2.re;
        tmp.im = c1.im - c2.im ;
        return tmp;
    }


    public static NumarComplex inmultire(NumarComplex c1, NumarComplex c2){
        NumarComplex tmp = new NumarComplex (0,0);
        tmp.re = c1.re * c2.re - c1.im * c2.im;
        tmp.im = c1.re * c2.im + c1.im * c2.re ;
        return tmp;
    }


    public static NumarComplex impartire(NumarComplex c1, NumarComplex c2){
        NumarComplex tmp = new NumarComplex(0, 0);
        if (c2.re == 0 && c2.im == 0) {
            tmp.re = 0;
            tmp.im = 0;
        } else {
            tmp.re = (c1.re * c2.re - c1.im * c2.im) / (c1.re * c1.re + c1.im * c1.im);
            tmp.im = (c1.re * c2.im + c1.im * c2.re) / (c1.re * c1.re + c1.im * c1.im);
        }
        return tmp;
    }


    public static NumarComplex conjugat(NumarComplex c1){
        NumarComplex tmp = new NumarComplex (0,0);
        tmp.re = c1.re;
        tmp.im = -c1.im;
        return tmp;
    }


}

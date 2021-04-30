package PolyCalculator;



public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }
    public Monomial(String s,int exp){
        this.exponent=exp;
        if(!containsdivide(s)){
            int a= java.lang.Integer.parseInt(s);
            this.coefficient=new Integer(a);
        }
        else{
            int up;
            int down;
            String a="";
            String b="";
            boolean g=false;
            for (int i = 0; i <s.length() ; i++) {
                if(s.charAt(i)!='/'&&!g)
                    a=a+s.charAt(i);
                if(s.charAt(i)!='/'&&g)
                    b=b+s.charAt(i);
                if(s.charAt(i)=='/')
                    g=true;
            }
            up= java.lang.Integer.parseInt(a);
            down= java.lang.Integer.parseInt(b);
            this.coefficient=new Rational(up,down);


        }
    }

    public Monomial add (Monomial m) {
        if (this.sign()==0)
            return m;
        if (m.sign()==0)
            return this;
        if (this.exponent == m.exponent) {
            return new Monomial(exponent, this.coefficient.add(m.coefficient));
        }
        return null;
    }

    public Monomial mult (Monomial m) {
        return new Monomial(this.exponent + m.exponent, this.coefficient.mul(m.coefficient));
    }

    public Scalar evaluate (Scalar s) {

        return (s.power(exponent)).mul(coefficient);
    }

    public Monomial derivative() {
        if(exponent==0||this.sign()==0)
            return new Monomial(0,new Integer(0));

        Monomial m = new Monomial(exponent, coefficient);
        m.coefficient = m.coefficient.mul(new Integer(exponent));
        m.exponent -= 1;
        return m;
    }

    public int sign() {
        if (this.coefficient.equals(new Integer(0))) {
                return 0;
        }
        return java.lang.Integer.compare(this.coefficient.sign(), 0);
    }

    public boolean equals(Monomial m){
        if (this.coefficient.equals(new Integer(0))&&m.coefficient.equals(new Integer(0)))
            return true;
        return (this.coefficient==m.coefficient&&this.exponent==m.exponent);

    }


    @Override
    public String toString() {
        java.lang.Integer a = exponent;
        if (coefficient.equals(new Integer(0)))
            return "0";
        if (coefficient.equals(new Integer(1))&&exponent==1)
            return "X";
        if (coefficient.equals(new Integer(1))&&exponent>1)
            return "X^"+a.toString();

        if (exponent == 0)
            return coefficient.toString();
        if (exponent==1)
            return coefficient.toString()+"X";


            return coefficient.toString() + "X^" + a.toString();

    }




    private boolean containsdivide(String s){
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='/')
                return true;
        }
        return false;
    }



}


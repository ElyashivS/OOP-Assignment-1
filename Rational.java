package PolyCalculator;

public class Rational implements Scalar {
    int numerator;
    int denominator;
    public Rational(int numerator,int denominator){
        if (denominator==0)
        throw new IllegalArgumentException("denominator cannot be 0");
        this.numerator=numerator;
        this.denominator=denominator;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addRational(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        if(s.denominator!=this.denominator) {
            int a = s.denominator;
            int b = this.denominator;
            int c = b * a;
            int d = s.numerator * b;
            int e = this.numerator * a;
            int f = d + e;
            return new Rational(f, c);
        }
        else
            return new Rational(this.numerator+s.numerator,this.denominator);

    }

    @Override
    public Scalar addInteger(Integer s) {
        int a=(s.getNumber()*denominator)+numerator;
        return new Rational(a,denominator);
    }

    @Override
    public Scalar mulRational(Rational s) {
        return new Rational(s.getNumerator()*this.numerator,s.getDenominator()*this.denominator);
    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Rational(numerator*s.getNumber(),denominator);
    }

    @Override
    public Scalar power(int exponent) {
        int c=1;
        int d=1;
        int counter=exponent;
        while(exponent>0){
            c=c*this.numerator;
            d=d*this.denominator;
            exponent=exponent-1;
        }
        return new Rational(c,d);
    }

    @Override
    public int sign() {
       if ((numerator>0&denominator>0)||(numerator<0&denominator<0)) {
           return 1;
       }
           else if((numerator>0&denominator<0)||(numerator<0&denominator>0)){
               return -1;
           }
           return 0;
       }


    @Override
    public Scalar neg() {
        return new Rational(numerator*-1,denominator);
    }

    @Override
    public void Print() {
    System.out.print(this.numerator+"/"+this.denominator);
    }
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }
    public Rational reduce(Rational r){
        int m=numerator;
        int n=denominator;
        int gcd;
        if(m%n==0)
            return new Rational(m/n,1);
        else if(m==n) {
            return new Rational(1, 1);
        }
         if (m>n) {
            gcd = GCD(m, n);
        }
             else   {
                 gcd = GCD(n, m);
             }
            return new Rational(numerator/gcd,denominator/gcd);
        }


    private static int GCD(int m,int n){
        int r=m%n;
        while (r!=0){
            m=n;
            n=r;
            r=m%n;
        }
        return n;
    }

    @Override
    public String toString() {
        Rational toprint = reduce(this);
        java.lang.Integer a = toprint.numerator;
        java.lang.Integer b = toprint.denominator;

        if (toprint.denominator == 1) {
            a = toprint.numerator;
            return a.toString();
        } else {
            int sign = this.sign();
            if (sign == 0) {
                return "0";
            } else if (sign == 1) {
                return a.toString() + "/" + b.toString();
            }
            else {
                if (b<0)
                    b=b*-1;
                if (a<0)
                    a=a*-1;
                return "-"+a.toString() + "/" + b.toString();
            }
        }
    }


    public static void main(String[] args) {
        Scalar a=new Rational(2,3);
        Scalar b=new Integer(105);
        Scalar c=a.power(3);
        Scalar d=c.neg();

        System.out.println(a.add(b).toString());
        System.out.println(b.toString());

    }
}

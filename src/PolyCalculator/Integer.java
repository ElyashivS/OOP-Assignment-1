package PolyCalculator;



public class Integer implements Scalar {
    private int number;
    public Integer(int number){
        this.number=number;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }



    @Override
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        int a=(number*s.getDenominator())+s.getNumerator();
        return new Rational(a,s.getDenominator());
    }

    @Override
    public Scalar addInteger(Integer s){
        return new Integer(this.number+s.number);
    }

    @Override
    public Scalar mulRational(Rational s) {
        return new Rational(s.getNumerator()*number,s.getDenominator());
    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Integer(this.number*s.number);
    }

    @Override
    public Scalar power(int exponent) {
        if (this.number==0&&exponent==0)
            return new Integer(1);
        if (this.number==0&&exponent>0)
            throw new IllegalArgumentException("0 by the power of negative is not defined");

            int c=1;
        int counter=exponent;
        while(exponent>0){
            c=c*this.number;
            exponent=exponent-1;
        }
        return new Integer(c);
    }

    @Override
    public int sign() {
        if(this.number>0)
            return 1;
        if (this.number<0)
            return -1;
        return 0;
    }

    @Override
    public Scalar neg() {
        return new Integer(this.number*-1);
    }


    public int getNumber(){
        return number;
    }

    @Override
    public String toString() {
        java.lang.Integer a=number;
        return a.toString();
    }
    @Override
    public boolean equals(Scalar s){
        return s.equalsInteger(this);
    }
    @Override
    public boolean equalsInteger(Integer s) {
        return (s.number == this.number);
    }

    @Override
    public boolean equalsRational(Rational s) {
        Rational a=s.reduce(s);
        if( a.getDenominator()==1){
            return a.getNumerator()==number;
        }
        else{
            return false;
        }

    }




}
package PolyCalculator;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public Monomial add (Monomial m) {
        if (this.exponent == m.exponent) {
            return new Monomial(exponent, this.coefficient.add(m.coefficient));
        }
        return null;
    }

    public Monomial mult (Monomial m) {
        return new Monomial(this.exponent * m.exponent, this.coefficient.mul(m.coefficient));
    }

    public Scalar evaluate (Scalar s) {
        s.power(exponent);
        s.mul(coefficient);
        return s;
    }

    public Monomial derivative() {
        Monomial m = new Monomial(exponent, coefficient);
        m.coefficient = m.coefficient.mul(new Integer(exponent));
        m.exponent -= 1;
        return m;
    }

    public int sign() {
        return java.lang.Integer.compare(this.coefficient.sign(), 0);
    }

    @Override
    public String toString() {
        return this.coefficient + "X^" + this.exponent;
    }
    public static void main (String[]args){
        Scalar q = new Integer(2);
        Scalar s = new Rational(2, 3);
        Monomial m = new Monomial(2, q);
        System.out.println(m.evaluate(s));

        Scalar in = new Rational(49, 7);
        System.out.println(in.power(2));
    }
}


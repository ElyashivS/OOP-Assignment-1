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
        return (s.power(exponent)).mul(coefficient);
    }

    public Monomial derivative() {
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

    @Override
    public String toString() {
        String s = "";
        if (this.exponent == 0) {
            return s += this.coefficient;
        }

        if (this.coefficient.equals(new Integer(0))) {
            return s;
        }

        if (this.coefficient.equals(new Integer(1)) && this.exponent == 1)
            return s += "X";

        if (this.coefficient.equals(new Integer(1))) {
            return s += "X^" + this.exponent;
        }

        if (this.exponent == 1) {
            return s += this.coefficient + "X";
        }

        if (this.coefficient.equals(new Integer(-1))) {
            return s += "-X^" + this.exponent;
        }

        return s += this.coefficient + "X^" + this.exponent;
    }
}


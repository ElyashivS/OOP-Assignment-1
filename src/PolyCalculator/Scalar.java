package PolyCalculator;

public interface Scalar {


    public Scalar add(Scalar s);
    public Scalar mul(Scalar s);
    public Scalar addRational(Rational s);
    public Scalar addInteger(Integer s);
    public Scalar mulRational(Rational s);
    public Scalar mulInteger(Integer s);
    public Scalar power(int exponent);
    public int sign();
    public Scalar neg();
    public boolean equals(Integer s);
    public boolean equals(Rational s);

}

package PolyCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {
    private Integer f; // 2
    private Rational h; // 2/3
    private Rational q; // 8/10

    private Scalar t; // 10

    @BeforeEach
    void setUp() {
        f = new Integer(2);
        h = new Rational(2, 3);
        q = new Rational(8, 10);

        t = new Integer(10);
    }

    @Test
    void add() {
        Scalar i = h.add(h);
        assertEquals("4/3", i.toString());
    }

    @Test
    void mul() {
        Scalar i = h.mul(h);
        assertEquals("4/9", i.toString());
    }

    @Test
    void addRational() {
        Scalar i = h.addRational(h);
        assertEquals("4/3", i.toString());
    }

    @Test
    void addInteger() {
        Scalar i = h.addInteger(f);
        assertEquals("8/3", i.toString());
    }

    @Test
    void mulRational() {
        Scalar i = h.mulRational(h);
        assertEquals("4/9", i.toString());
    }

    @Test
    void mulInteger() {
        Scalar i = h.mulInteger(f);
        assertEquals("4/3", i.toString());
    }

    @Test
    void power() {
        Scalar i = h.power(2);
        assertEquals("4/9", i.toString());
    }

    @Test
    void sign() {
        int i = h.sign();
        assertEquals(1, i);
    }

    @Test
    void neg() {
        Scalar i = h.neg();
        assertEquals("-2/3", i.toString());
    }

    @Test
    void testEquals() {
        boolean i = t.equals(h);
        assertFalse(i);
    }

    @Test
    void getNumerator() {
        assertEquals(2, h.getNumerator());
    }

    @Test
    void getDenominator() {
        assertEquals(3, h.getDenominator());
    }

    @Test
    void reduce() {
        Scalar i = q.reduce(q);
        assertEquals("4/5", q.toString());
    }
}

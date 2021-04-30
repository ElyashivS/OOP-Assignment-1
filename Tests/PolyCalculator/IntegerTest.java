package PolyCalculatorTests;

import PolyCalculator.Integer;
import PolyCalculator.Rational;
import PolyCalculator.Scalar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerTest {
    private Integer f; // 2
    private Rational h; // 2/3

    private Scalar t; // 10

    @BeforeEach
    void setUp() {
        f = new Integer(2);
        h = new Rational(2, 3);

        t = new Integer(10);
    }

    @Test
    void add() {
        Scalar i = f.add(f);
        assertEquals("4", i.toString());
    }

    @Test
    void mul() {
        Scalar i = f.mul(f);
        assertEquals("4", i.toString());
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
        Scalar i = f.mulInteger(f);
        assertEquals("4", i.toString());
    }

    @Test
    void power() {
        Scalar i = f.power(2);
        assertEquals("4", i.toString());
    }

    @Test
    void sign() {
        int i = f.sign();
        assertEquals(1, i);

    }

    @Test
    void neg() {
        Scalar i = f.neg();
        assertEquals("-2", i.toString());
    }

    @Test
    void testEquals() {
        boolean i = t.equals(f);
        assertFalse(i);
    }

    @Test
    void testEquals1() {
        boolean i = t.equals(h);
        assertFalse(i);
    }

    @Test
    void testToString() {
        assertEquals("2", f.toString());
    }
}
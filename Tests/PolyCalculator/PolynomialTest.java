package PolyCalculatorTests;

import PolyCalculator.Integer;
import PolyCalculator.Polynomial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class PolynomialTest {
    private Polynomial p1;
    private Polynomial p2;

    @BeforeEach
    void setUp() {
        p1 = Polynomial.build("2 4");
        p2 = Polynomial.build("1/2 3");
    }

    @Test
    void add() {
        assertEquals("5/2+7X", (p1.add(p2)).toString());
    }

    @Test
    void mul() {
        p1.mul(p2);
        assertEquals("1+8X+12X^2", (p1.mul(p2)).toString());
    }

    @Test
    void evaluate() {
        assertEquals("30", this.p1.evaluate(new Integer(7)).toString());
    }

    @Test
    void derivative() {
        assertEquals("4", (p1.derivative()).toString());
    }

    @Test
    void testToString() {
        assertEquals("2+4X", p1.toString());
    }
}
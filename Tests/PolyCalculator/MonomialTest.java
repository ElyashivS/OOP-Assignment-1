package PolyCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {
    private Scalar f; // 2
    private Monomial m; // 2X^2
    private Scalar h; // 2/3

    private Scalar t; // 10
    private Monomial e; // 10X^2

    private int x;

    @BeforeEach
    void setUp() {
        f = new Integer(2);
        m = new Monomial(2, f);
        h = new Rational(2, 3);

        e = new Monomial(2, t);
        t = new Integer(10);

        x = 43;
    }

    @Test
    void add() {
        Monomial s = m.add(m);
        assertEquals("4X^2", s.toString());
    }

    @Test
    void mult() {
        Monomial s = m.mult(m);
        assertEquals("4X^4", s.toString());
    }

    @Test
    void evaluate() {
        Scalar s = m.evaluate(h);
        assertEquals("8/9", s.toString());
    }

    @Test
    void derivative() {
        Monomial s = m.derivative();
        assertEquals("4X", s.toString());
    }

    @Test
    void sign() {
        x = m.sign();
        assertEquals(1, x);
    }
}
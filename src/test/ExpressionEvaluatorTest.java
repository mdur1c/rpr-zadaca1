package ba.etf.unsa.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {

    /**
     * Testira rad za sabiranje (sa racionalnim brojem)
     */
    @Test
    void evaluate1() {
        assertEquals(ExpressionEvaluator.evaluate("( 2.5 + 3 )"), 5.5D);
    }

    /**
     * Testira operatore * i -
     */
    @Test
    void evaluate2() {
        assertEquals(3D, ExpressionEvaluator.evaluate("( ( ( 2 + 3 ) * 3 ) - 12 )"));
    }

    /**
     * Testira operator / i mix drugih operacija
     */
    @Test
    void evaluate3() {
        assertEquals(13.5D, ExpressionEvaluator.evaluate("( 27 / ( ( ( 2 + 3 ) * 3 ) - 13 ) )"));
    }

    /**
     * Testira sqrt funkciju
     */
    @Test
    void evaluate4() {
        assertEquals(5D, ExpressionEvaluator.evaluate("( sqrt ( ( ( 2 + 3 ) * 3 ) + 10 ) )"));
    }

    /**
     * Testira izuzetak za nepostojeci operator
     */
    @Test
    void evaluate5() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( 2 # 3 )"));
    }

    /**
     * Testira izuzetak za nepostojeci broj
     */
    @Test
    void evaluate6() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( 2 + # )"));
    }

    /**
     * Testira izuzetak za argument bez razmaka gdje treba biti
     */
    @Test
    void evaluate7() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("(2 + 3 )"));
    }

    /**
     * Testira izuzetak za argument sa suvisnim razmakom
     */
    @Test
    void evaluate8() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("(  2 + 3 )"));
    }

    /**
     * Testira redoslijed operacija sa zagradama
     */
    @Test
    void evaluate9() {
        assertEquals(0.6D, ExpressionEvaluator.evaluate("( ( 7 + 3 ) * ( 4 + 2 ) / ( 9 + 1 ) )"));
    }

    /**
     * Testira operator stepena ^
     */
    @Test
    void evaluate10() {
        assertEquals(128D, ExpressionEvaluator.evaluate("( ( 2 ^ 3 ) * ( 4 ^ 2 ) )"));
    }
}

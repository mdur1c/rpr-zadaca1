package ba.etf.unsa.rpr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExpressionEvaluatorTest {
    ExpressionEvaluatorTest() {
    }

    @Test
    void test1() {
        Assertions.assertEquals(ExpressionEvaluator.evaluate("( 2.8 + 3 )"), 5.8);
    }

    @Test
    void test2() {
        Assertions.assertEquals(13.5, ExpressionEvaluator.evaluate("( 27 / ( ( ( 2 + 3 ) * 3 ) - 13 ) )"));
    }

    @Test
    void test3() {
        Assertions.assertEquals(3.0, ExpressionEvaluator.evaluate("( sqrt ( ( ( 2 + 1 ) * 3 ) + 0 ) )"));
    }

    @Test
    void test4() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("( 2 # 3 )");
        });
    }

    @Test
    void test5() {
        Assertions.assertEquals(3.0, ExpressionEvaluator.evaluate("( ( ( 2 + 3 ) * 3 ) - 12 )"));
    }

    @Test
    void test6() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("( 2 + # )");
        });
    }

    @Test
    void test7() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("(99 + 3 )");
        });
    }

    @Test
    void test8() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("(  2 + 9 )");
        });
    }

    @Test
    void test9() {
        Assertions.assertEquals(0.6, ExpressionEvaluator.evaluate("( ( 7 + 3 ) * ( 4 + 2 ) / ( 9 + 1 ) )"));
    }

    @Test
    void test10() {
        Assertions.assertEquals(128.0, ExpressionEvaluator.evaluate("( ( 2 ^ 3 ) * ( 4 ^ 2 ) )"));
    }
}


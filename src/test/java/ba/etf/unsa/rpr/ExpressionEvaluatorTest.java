package ba.etf.unsa.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    class ExpressionEvaluatorTest {


        @Test
        void test1() {
            assertEquals(ExpressionEvaluator.evaluate("( 2.8 + 3 )"), 5.8D);
        }



        @Test
        void test2() {
            assertEquals(13.5D, ExpressionEvaluator.evaluate("( 27 / ( ( ( 2 + 3 ) * 3 ) - 13 ) )"));
        }


        @Test
        void test3() {
            assertEquals(3D, ExpressionEvaluator.evaluate("( sqrt ( ( ( 2 + 1 ) * 3 ) + 0 ) )"));
        }


        @Test
        void test4() {
            assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( 2 # 3 )"));
        }

        @Test
        void test5() {
            assertEquals(3D, ExpressionEvaluator.evaluate("( ( ( 2 + 3 ) * 3 ) - 12 )"));
        }


        @Test
        void test6() {
            assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( 2 + # )"));
        }


        @Test
        void test7() {
            assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("(99 + 3 )"));
        }


        @Test
        void test8() {
            assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("(  2 + 9 )"));
        }


        @Test
        void test9() {
            assertEquals(0.6D, ExpressionEvaluator.evaluate("( ( 7 + 3 ) * ( 4 + 2 ) / ( 9 + 1 ) )"));
        }


        @Test
        void test10() {
            assertEquals(128D, ExpressionEvaluator.evaluate("( ( 2 ^ 3 ) * ( 4 ^ 2 ) )"));
        }
    }



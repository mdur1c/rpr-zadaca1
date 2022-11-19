package ba.etf.unsa.rpr;

import java.util.Stack;

public class ExpressionEvaluator {
    private static Stack<String> operators;
    private static Stack<Double> values;
    private static final RuntimeException e_arg = new RuntimeException("Argument not valid");

    public static Double evaluate(String expr) throws RuntimeException {
        Stack<String> operators = new Stack<String>();
        Stack<Double> values = new Stack<Double>();
        String[] expression=expr.split(" ");
        for(int i=0;i<expression.length;i++) {
            if(expression[i].equals("+")) operators.push(expression[i]);
            else if(expression[i].equals("-")) operators.push(expression[i]);
            else if(expression[i].equals("*")) operators.push(expression[i]);
            else if(expression[i].equals("/")) operators.push(expression[i]);
            else if(expression[i].equals("%")) operators.push(expression[i]);
            else if(expression[i].equals("^")) operators.push(expression[i]);
            else if(expression[i].equals("sqrt")) operators.push(expression[i]);
            else if(expression[i].equals("(")) continue;
            else if(expression[i].equals(")")) {

                String operator=operators.pop();
                double value=values.pop();

                if(operator.equals("+"))   value=values.pop()+(value);
                else if(operator.equals("-"))   value=values.pop()-(value);
                else if(operator.equals("*"))   value=values.pop()*(value);
                else if(operator.equals("/"))   value=values.pop()/(value);
                else if(operator.equals("%"))   value=values.pop()%(value);
                else if(operator.equals("^"))   value=Math.pow(values.pop(), value);
                else if(operator.equals("sqrt"))   value=Math.sqrt(value);
                values.push(value);

            }
            else try {values.push(Double.parseDouble(expression[i]));
                } catch (NumberFormatException e) {
                    throw e_arg;
                }
        }
        return values.peek();


    }
}

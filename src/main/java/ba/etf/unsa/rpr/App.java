package ba.etf.unsa.rpr;


public class App 
{

    public static void main(String[] args) {
        String string = new String();

        for (int i=0; i< args.length; i++) {
            if (i!=0)
                string+=" ";

            string+=args[i];
        }

        try {
            System.out.println(ExpressionEvaluator.evaluate(string));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}

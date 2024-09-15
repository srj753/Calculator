
public class RightParenOperator extends Operator {
    public RightParenOperator() {
        super(2);
    }

    @Override
    public double evaluate(double a, double b) {
    	throw new UnsupportedOperationException("Parentheses do not evaluate");
    }
}




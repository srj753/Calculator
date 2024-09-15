
public class LeftParenOperator extends Operator {
    public LeftParenOperator() {
        super(1);
    }

    @Override
    public double evaluate(double a, double b) {
    	throw new UnsupportedOperationException("Parentheses do not evaluate");
    }
}




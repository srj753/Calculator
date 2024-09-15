public class ExpOperator extends Operator {
    public ExpOperator() {
        super(5);
    }

    @Override
    public double evaluate(double a, double b) {
        return Math.pow(b, a);
    }
}

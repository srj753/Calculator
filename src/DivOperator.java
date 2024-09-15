public class DivOperator extends Operator {
    public DivOperator() {
        super(4);
    }

    @Override
    public double evaluate(double a, double b) {
        return b / a;
    }
}

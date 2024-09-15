public class SubOperator extends Operator {
    public SubOperator() {
        super(3);
    }

    @Override
    public double evaluate(double a, double b) {
        return b - a;
    }
}

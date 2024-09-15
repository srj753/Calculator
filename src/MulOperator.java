public class MulOperator extends Operator {
    public MulOperator() {
        super(4);
    }

    @Override
    public double evaluate(double a, double b) {
        return a * b;
    }
}

public class AddOperator extends Operator {
    public AddOperator() {
        super(3);
    }

    @Override
    public double evaluate(double a, double b) {
        return a + b;
    }
}

public abstract class Operator {
	private final int precedence;

	protected Operator(int precedence) {
		this.precedence = precedence;
	}

	public int getPrecedence() {
		return precedence;
	}

	public abstract double evaluate(double a, double b);
}
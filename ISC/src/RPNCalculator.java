import java.util.Scanner;

public class RPNCalculator {
	private static double[] operandStack;
	private static int top;

	public static void main (String[] args) {
		System.out.printf("Reverse Polish Expression    :    ");
		String expression = (new Scanner(System.in)).nextLine();
		double result = evaluateRPNExpression(expression);
		System.out.printf("Evaluated Expression         :    %s %n", Double.toString(result));
	}

	public static double evaluateRPNExpression (String expression) {
		String[] tokens = expression.split("\\s+");
		top = -1;
		operandStack = new double[tokens.length];

		for (String token : tokens) {
			if (isDouble(token)) {
				pushOperand(Double.parseDouble(token));
				continue;
			}
			
			double rightOperand = popOperand();
			double leftOperand = popOperand();
			double result = 0.0;
			switch (token.charAt(0)) {
				case '+' :	result = leftOperand + rightOperand;
						break;
				case '-' :	result = leftOperand - rightOperand;
						break;
				case '*' :	result = leftOperand * rightOperand;
						break;
				case '/' :	result = leftOperand / rightOperand;
						break;
				case '^' :	result = Math.pow(leftOperand, rightOperand);
						break;
				default  :	System.out.printf("Unknown operator (%s)!\n", token);
						System.exit(0);
			}
			pushOperand(result);
		}
		return popOperand();
	}

	private static void pushOperand (double n) {
		operandStack[++top] = n;
	}
	
	private static double popOperand () {
		if (top < 0) {
			System.out.println("Insufficient operands!");
			System.exit(0);
		}
		return operandStack[top--];
	}
	
	private static boolean isDouble (String n) {
		try {
			 Double.parseDouble(n);
			 return true;
		} catch (NumberFormatException e) {}
		return false;
	}
}

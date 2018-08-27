import java.util.Scanner;

public class RPNCalculator {
	/* Simple stack setup */
	private static double[] operandStack;
	private static int top;

	public static void main (String[] args) {
		/* Prompt an RPN expression from the terminal */
		System.out.printf("Reverse Polish Expression    :    ");
		String expression = (new Scanner(System.in)).nextLine();
		/* Evaluate the expression and display the result */
		double result = evaluateRPNExpression(expression);
		System.out.printf("Evaluated Expression         :    %s %n", Double.toString(result));
	}
	
	/* Evaluates expression in RPN */
	public static double evaluateRPNExpression (String expression) {
		/* Split the expression into tokens */
		String[] tokens = expression.split("\\s+");
		/* Initialize the stack with an appropriately large capacity */
		top = -1;
		operandStack = new double[tokens.length];
		
		/* Iterate through all tokens in the expression */
		for (String token : tokens) {
			/* Push operands into the stack and continue */
			if (isDouble(token)) {
				pushOperand(Double.parseDouble(token));
				continue;
			}
			
			/* Pop operands from the stack */
			double rightOperand = popOperand();
			double leftOperand = popOperand();
			/* Determine the operator encountered and calculate the appropriate result */
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
			/* Push the result onto the stack */
			pushOperand(result);
		}
		/* Return the last item in the stack */
		return popOperand();
	}
	
	/* Pushes an operand onto the stack */
	private static void pushOperand (double n) {
		operandStack[++top] = n;
	}
	
	/* Pops an operand from the stack. Exits on failure. */
	private static double popOperand () {
		if (top < 0) {
			System.out.println("Insufficient operands!");
			System.exit(0);
		}
		return operandStack[top--];
	}
	
	/* Determines whether a token is a number */
	private static boolean isDouble (String n) {
		try {
			 Double.parseDouble(n);
			 return true;
		} catch (NumberFormatException e) {}
		return false;
	}
}

// com/github/sahasatvik/math/MissingOperandException.java

package com.github.sahasatvik.math;

/**
 * Exception thrown when an expression passed to ExpressionParser has a missing 
 * operand.
 *
 * 	@author		Satvik Saha
 * 	@version	1.0, 16/10/2016
 * 	@see		com.github.sahasatvik.math.ExpressionParserException
 * 	@since		1.0
 */

public class MissingOperandException extends ExpressionParserException {
	private String op;

	/**
	 * Constructor of MissingOperandException.
	 *
	 * 	@param	faultyExpression	the expression which could not be parsed
	 * 	@param	op			the operator which is missing an operand
	 * 	@since	1.0
	 */

	public MissingOperandException (String faultyExpression, String op) {
		super(faultyExpression);
		this.op = op;
	}

	/**
	 * Gets the operator which is missing an operand.
	 *
	 * 	@return				the operator which is missing an operand
	 * 	@since	1.0
	 */

	public String getOperator () {
		return op;
	}
} 

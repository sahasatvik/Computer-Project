// src/com/github/sahasatvik/math/NullExpressionException.java

package com.github.sahasatvik.math;

/**
 * Exception thrown when an expression passed to ExpressionParser is empty.
 *
 * 	@author		Satvik Saha
 * 	@version	1.0, 16/10/2016
 * 	@see		com.github.sahasatvik.math.ExpressionParserException
 * 	@since		1.0
 */

public class NullExpressionException extends ExpressionParserException {
	
	/**
	 * Constructor of NullExpressionException.
	 *
	 * 	@since	1.0
	 */

	public NullExpressionException () {
		super("");
	}
} 

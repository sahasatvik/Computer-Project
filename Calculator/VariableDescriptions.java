	/** 		Variable Descriptions for Calculator and its libraries.   	*/

	/*
	 * 	src/Calculator.java
	 *				< Calculator >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	commandRegex	|	String		|  Regular expresion
	 *	   	   |			|			|  matching a command
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   2	   |	previousAns	|	String		|  Stores the previously
	 *	   	   |			|			|  evaluated answer
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   3	   |	expParser	|   ExpressionParser	|  Object with methods
	 *	   	   |			|			|  for evaluating math
	 *	   	   |			|			|  expressions
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *      			< Calculator.main(String[]) >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	expression	|	String		|  Store the expression
	 *	   	   |			|			|  entered
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   2	   |	command		|	String		|  Store the command
	 *	   	   |			|			|  entered
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   3	   |	inp		|	Scanner		|  Object with methods
	 *	   	   |			|			|  for input
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   4	   |	i		|	int		|  Counter variable
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *      			< Calculator.evaluate(String) >
	 *      			< Calculator.parseCommand(String) >
	 */
	
	/*
	 *	src/CommandNotFoundException.java
	 *      			< CommandNotFoundException >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	command		|	String		|  Store the invalid
	 *	   	   |			|			|  entered
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	
	 *      			< CommandNotFoundException
	 *      			      .CommandNotFoundException(String) >
	 *      			< CommandNotFoundException.getCommand() >
	 */
	
	/*
	 * 	src/com/github/sahasatvik/math/ExpressionParser.java
	 *				< ExpressionParser >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	numberRegex	|	String		|  Regular expresion
	 *	   	   |			|			|  matching a number
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   2	   | signedNumberRegex	|	String		|  Regular expresion
	 *	   	   |			|			|  matching a signed
	 *	   	   |			|			|  number
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   3	   |  assignmentRegex	|	String		|  Regular expresion
	 *	   	   |			|			|  matching an
	 *	   	   |			|			|  assignment statement
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   4	   |	operators	|	String[]	|  Array of arithmetic
	 *	   	   |			|			|  operators (BODMAS)
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   5	   |	variables	|   	String[][]	|  Array of variable
	 *	   	   |			|			|  names and values
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   6	   |	numberOfVars	|	int		|  Number of variables
	 *	   	   |			|			|  currently defined
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *				< ExpressionParser.ExpressionParser(int) >
	 *				< ExpressionParser.addVariable(String, String) >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	i		|	int		|  Counter variable
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *				< ExpressionParser.evaluate(String) >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	result		|	String		|  Store the result after
	 *	   	   |			|			|  evaluating expressions
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *				< ExpressionParser.parseVariables(String) >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	i		|	int		|  Counter variable
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   2	   |	start		|	int		|  Store index of opening
	 *	   	   |			|			|  angled brackets ('<')
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   3	   |	end		|	int		|  Store index of closing
	 *	   	   |			|			|  angled brackets ('>')
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *				< ExpressionParser.parseParenthesis(String) >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	result		|	String		|  Store the result after
	 *		   |			|			|  evaluating the part
	 *		   |			|			|  in parenthesis
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   2	   |	start		|	int		|  Store index of opening
	 *	   	   |			|			|  parenthesis ('(')
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   3	   |	end		|	int		|  Store index of closing
	 *	   	   |			|			|  parenthesis (')')
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *				< ExpressionParser.parseFunctions(String) >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	result		|	String		|  Store the result after
	 *		   |			|			|  evaluating the part
	 *		   |			|			|  in parenthesis
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   2	   |	func		|	String		|  Store the function
	 *	   	   |			|			|  name
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   3	   |	x		|	double		|  Store the value of the
	 *	   	   |			|			|  function argument
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   4	   |	start		|	int		|  Store index of opening
	 *	   	   |			|			|  square brackets ('[')
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   5	   |	end		|	int		|  Store index of closing
	 *	   	   |			|			|  square brackets (']')
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *				< ExpressionParser.parseOperators(String) >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	leftIndex	|	int		|  Store index of left
	 *	   	   |			|			|  operand
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   2	   |	rightIndex	|	int		|  Store index of right
	 *	   	   |			|			|  operand
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   3	   |	stack		|	String[]	|  Store the expression
	 *		   |			|			|  after dividing it
	 *		   |			|			|  along the spaces
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   4	   |	op		|	String		|  Store the operator
	 *	   	   |			|			|  name
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   5	   |	i		|	int		|  Counter variable
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   6	   |	left		|	int		|  Store the left
	 *	   	   |			|			|  operand
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   7	   |	right		|	int		|  Store the right
	 *	   	   |			|			|  operand
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *				< ExpressionParser.adjustNumberSpacing(String) >
	 *				< ExpressionParser
	 *					.addVariable(String, int, char, char) >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	tmp		|	int		|  Temporary variable,
	 *		   |			|			|  store the position of
	 *		   |			|			|  the opening bracket
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */
	
	/*
	 * 	src/com/github/sahasatvik/math/MathParser.java
	 *				< MathParser >
	 *				< MathParser.isNumber(String) >
	 *				< MathParser.factorial(double) >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	n		|   	double		|  Counter for
	 *	   	   |			|			|  multiplying to get
	 *	   	   |			|			|  the factorial
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *      			< MathParser
	 *      				.solveBinaryOperation(double, String, double) >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	result		|	String		|  Store the evaluated
	 *	   	   |			|			|  result
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *      			< MathParser
	 *      				.solveUnaryFunction(String, double) >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	result		|	String		|  Store the evaluated
	 *	   	   |			|			|  result
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */
	
	/*
	 * 	src/com/github/sahasatvik/math/ExpressionParserException.java
	 *				< ExpressionParserException >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |  faultyExpression	|   	String		|  Store the invalid
	 *	   	   |			|			|  expression
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *				< ExpressionParserException
	 *					.ExpressionParserException(String) >
	 *				< ExpressionParserException
	 *					.getFaultyExpression() >
	 */
	
	/*
	 * 	src/com/github/sahasatvik/math/NullExpressionException.java
	 *				< NullExpressionException >
	 *				< NullExpressionException
	 *					.NullExpressionException() >
	 */
	
	/*
	 * 	src/com/github/sahasatvik/math/UnmatchedBracketsException.java
	 *				< UnmatchedBracketsException >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	pos		|   	int		|  Store the index of the
	 *	   	   |			|			|  unmatched bracket
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *				< UnmatchedBracketsException
	 *					.UnmatchedBracketsException(String, int) >
	 *				< UnmatchedBracketsException
	 *					.getIndexOfBracket() >
	 */
	
	/*
	 * 	src/com/github/sahasatvik/math/MissingOperandException.java
	 *				< MissingOperandException >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	op		|   	String		|  Store the operator
	 *	   	   |			|			|  which has a missing
	 *	   	   |			|			|  operand
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *				< MissingOperandException
	 *					.MissingOperandException(String, int) >
	 *				< MissingOperandException
	 *					.getOperator() >
	 */
	
	/*
	 * 	src/com/github/sahasatvik/math/VariableNotFoundException.java
	 *				< VariableNotFoundException >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	var		|   	String		|  Store the name of the
	 *	   	   |			|			|  unrecognized variable
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *				< VariableNotFoundException
	 *					.VariableNotFoundException(String, String) >
	 *				< VariableNotFoundException
	 *					.VariableNotFoundException(String) >
	 *				< VariableNotFoundException
	 *					.getVar() >
	 */
	
	/*
	 * 	src/com/github/sahasatvik/math/FunctionNotFoundException.java
	 *				< FunctionNotFoundException >
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	func		|   	String		|  Store the name of the
	 *	   	   |			|			|  unrecognized function
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *				< FunctionNotFoundException
	 *					.FunctionNotFoundException(String, String) >
	 *				< FunctionNotFoundException
	 *					.FunctionNotFoundException(String) >
	 *				< FunctionNotFoundException
	 *					.getFunc() >
	 */

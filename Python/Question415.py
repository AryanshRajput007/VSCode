def infix_evaluation(expr):
  """
  Evaluates an infix expression using a stack-based approach.

  Args:
    expr: The infix expression to evaluate.

  Returns:
    The evaluated result of the expression.
  """

  operators = {
      "+": lambda a, b: a + b,
      "-": lambda a, b: a - b,
      "*": lambda a, b: a * b,
      "/": lambda a, b: a / b,
  }

  precedence = {
      "+": 1,
      "-": 1,
      "*": 2,
      "/": 2,
  }

  operand_stack = []
  operator_stack = []

  for token in expr.split():
    if token in operators:
        while operator_stack and precedence[operator_stack[-1]] >= precedence[token]:
            operand2 = operand_stack.pop()
            operand1 = operand_stack.pop()
            operator = operator_stack.pop()
            result = operators[operator](operand1, operand2)
        operand_stack.append(result)
        operator_stack.append(token)
    else:
        operand_stack.append(float(token))

    while operator_stack:
        operand2 = operand_stack.pop()
        operand1 = operand_stack.pop()
        operator = operator_stack.pop()
        result = operators[operator](operand1, operand2)
        operand_stack.append(result)

    return operand_stack[0]

# Example usage
expr = "4 + 5 - 9 * 2"
result = infix_evaluation(expr)
print(result)  # Output: -3.0

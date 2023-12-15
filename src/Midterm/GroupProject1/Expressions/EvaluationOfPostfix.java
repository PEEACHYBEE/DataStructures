package Midterm.GroupProject1.Expressions;
import Midterm.GroupProject1.Stack.MyStack;
import Midterm.GroupProject1.Stack.StackUnderflowException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**Authors: Chloe Lee San Miguel
 *          Jan Dolby Aquino
 *          Ma. Earl Freskkie Encarnacion
 *Programming Date: October 21, 2023
 */

public class EvaluationOfPostfix extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    public EvaluationOfPostfix() {
        model = new DefaultTableModel();
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setTitle("Table for Conversion");
        setSize(500, 600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        model.addColumn("Symbol");
        model.addColumn("Operand 1");
        model.addColumn("Operand 2");
        model.addColumn("Value");
        model.addColumn("Operand Stack");
    }

    /**
     * Evaluates a postfix expression and returns the result.
     * @param output The postfix expression to be evaluated.
     * @return The result of the expression evaluation.
     * @throws StackUnderflowException If there is not enough operands for an operator.
     */
    public double evaluate(String output) throws StackUnderflowException {
        MyStack<Double> operandStack = new MyStack<>();
        StringBuilder operatorStackStr = new StringBuilder();
        double operand1 = 0;
        double operand2 = 0;
        double value = 0;

        for (int i = 0; i < output.length(); i++) {
            char symbol = output.charAt(i);

            if (symbol != ' ') {
                if (Character.isDigit(symbol)) {
                    operandStack.push((double) (symbol - '0'));
                } else {
                    if (operandStack.size() < 2) {
                        throw new StackUnderflowException("Not enough operands for operator: " + symbol);
                    }

                    operand2 = operandStack.pop();
                    operand1 = operandStack.pop();
                    value = evaluateOperands(operand1, operand2, symbol);
                    operandStack.push(value);

                    operatorStackStr.append(symbol);
                }
                addRowToTable(String.valueOf(symbol), String.valueOf(operand1),
                        String.valueOf(operand2), String.valueOf(value), operatorStackStr.toString());
            }
        }
        return operandStack.pop();
    }

    private String getOperatorStackString(MyStack<Character> operatorStack) {
        StringBuilder operatorStackStr = new StringBuilder();
        for (int i = 0; i < operatorStack.size(); i++) {
            operatorStackStr.append(operatorStack.get(i));
        }
        return operatorStackStr.toString();
    }

    /**
     * Evaluates two operands with the given operator and returns the result.
     * @param operand1 The first operand.
     * @param operand2 The second operand.
     * @param operator The operator to apply.
     * @return The result of the operation.
     * @throws ArithmeticException     If division by zero is attempted.
     * @throws IllegalArgumentException If an invalid operator is encountered.
     */
    public double evaluateOperands(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            case '^':
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    } // end of evaluateOperands method

    public void addRowToTable(String symbol, String operandOne, String operandTwo, String value, String operatorStack) {
        model.addRow(new Object[]{symbol, operandOne, operandTwo, value, operatorStack});
    }
}

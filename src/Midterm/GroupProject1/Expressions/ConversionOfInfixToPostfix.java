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

public class ConversionOfInfixToPostfix extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public ConversionOfInfixToPostfix() {
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
        model.addColumn("Postfix Expression");
        model.addColumn("Operator Stack");
    }

    public String convert(String input) throws StackUnderflowException {
        StringBuilder output = new StringBuilder();
        MyStack<Character> operatorStack = new MyStack<>();
        StringBuilder operatorStackStr = new StringBuilder();  // New StringBuilder for operator stack

        char topSymbol;
        char symbol = ' ';

        for (int i = 0; i < input.length(); i++) {
            symbol = input.charAt(i);

            if (Character.isLetterOrDigit(symbol)) {
                output.append(symbol);
            } else {
                // Maintain the operatorStackStr manually
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek(), symbol)) {
                    topSymbol = operatorStack.pop();
                    output.append(topSymbol);
                    operatorStackStr.setLength(operatorStackStr.length() - 1); // Remove the last character
                }
                if (symbol != ')') {
                    operatorStack.push(symbol);
                    operatorStackStr.append(symbol);
                } else {
                    while (!operatorStack.peek().equals('(')) {
                        output.append(operatorStack.pop());
                        operatorStackStr.setLength(operatorStackStr.length() - 1); // Remove the last character
                    }
                    operatorStack.pop();
                }
            }
            addRowToTable(String.valueOf(symbol), output.toString(), operatorStackStr.toString());
        }

        while (!operatorStack.isEmpty()) {
            topSymbol = operatorStack.pop();
            output.append(topSymbol);
            operatorStackStr.setLength(operatorStackStr.length() - 1); // Remove the last character
        }
        return output.toString();
    }

    // Define a method to check the precedence of operators.
    public boolean precedence(char operator1, char operator2) {
        return (operator1 == '^' || operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-');
    } // end of precedence method

    public void addRowToTable(String symbol, String postFixExpression, String operatorStack) {
        model.addRow(new Object[]{symbol, postFixExpression, operatorStack});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConversionOfInfixToPostfix conversionApp = new ConversionOfInfixToPostfix();
        });
    }
}

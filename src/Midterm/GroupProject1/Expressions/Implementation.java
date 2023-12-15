package Midterm.GroupProject1.Expressions;
import Midterm.GroupProject1.Stack.StackUnderflowException;

import java.util.*;
/**Authors: Chloe Lee San Miguel
 *          Jan Dolby Aquino
 *          Ma. Earl Freskkie Encarnacion
 *Programming Date: October 21, 2023
 */
public class Implementation {
    private Scanner kbd = new Scanner(System.in);

    public static void main(String[] args) {
        Implementation program;
        try {
            program = new Implementation();
            program.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // end of main method

    public void run() throws StackUnderflowException {
        int choice = 0;
        while (choice != 3) {
            mainMenu();
            choice = Integer.parseInt(readString("Please select from the options above: "));
            switch (choice) {
                case 1 -> conversion();
                case 2 -> evaluation();
            }
        }
        System.out.println("\nProgram terminated.\n");
        System.exit(0);
    } // end of run method

    public void conversion() throws StackUnderflowException {
        ConversionOfInfixToPostfix conversion = new ConversionOfInfixToPostfix();
        String infix;

        System.out.println("\nConvert Infix Expression to Postfix Expression");
        System.out.println("================================================");
        infix = readString("Input an Infix Expression: ");
        String postfix = conversion.convert(infix);
        System.out.println("Infix Expression: " + infix);
        System.out.println("Postfix Expression: " + postfix);
    } // end of conversion method

    public void evaluation() throws StackUnderflowException {
        EvaluationOfPostfix evaluation = new EvaluationOfPostfix();
        String postfix;
        System.out.println("\nEvaluate a Postfix Expression");
        System.out.println("===============================");
        postfix = readString("Input a Postfix Expression: ");
        double postfixResult = evaluation.evaluate(postfix);
        System.out.println("Postfix Expression: " + postfix);
        System.out.println("Postfix Result: " + postfixResult);
    } // end of evaluation method

    public void mainMenu() {
        System.out.println("========================================");
        System.out.println("|       Midterm Group Project 1       |");
        System.out.println("| 1. Conversion of Infix to Postfix   |");
        System.out.println("| 2. Evaluation of Postfix            |");
        System.out.println("| 3. Exit the Program                 |");
        System.out.println("|=====================================|");
    } // end of mainMenu method

    // Display the main options for the user
    public String readString(String promptMessage) {
        System.out.print(promptMessage);
        return kbd.nextLine();
    } // end of readString method
}

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// TODO implement parentheses
// TODO complex numbers

/**
 * INSTRUCTIONS:
 * 
 * Getting started
 * 1. Run the code, then enter a number into the console. Press enter.
 * 2. 
 * 		- Option 1: Enter a unary operator. The unary operator will be applied to the last number entered.
 * 		- Option 2: Enter a second number, then enter a binary operator. The operation will be applied like last_num_entered 
 * 								(op) first_num.
 * 
 * Special commands
 * - At any point, if you want to see what the stack looks like, output RETURN.
 * - Type EXIT to exit the program.
 * - Type REDO to redo an operation and UNDO to undo an operation.
 * 
 * How the calculator works
 * - If the operation entered is unary, the last entered number will be popped out, operated on and inserted back into the stack.
 * - If the operation entered is binary, the last two numbers in the stack (top and under the top) will be popped out and one 
 * number will be inserted back into the stack. The operation will be applied last_num_entered (op) first_num.
 * - See a full list of operations and what each is named in undoCalculator.txt
 */

class UndoCalculator {

	Stack<Double> mainStack = new Stack<Double>();
	Stack<Double> undoStack = new Stack<Double>();
	String [] binary_operations = {"+", "-", "/", "*", "%", "**", "//", "gcd", "lcm", "|", "&", "^"};
	String [] unary_operations = {"||", "√", "++", "--", "~", "sin", "cos", "tan", "sec", "csc", "cot"};
	String [] special_operations = {"UNDO", "REDO"};

	UndoCalculator() {}

	private void handleUnaryOperation(String operation) {
		Double a = mainStack.pop();
		Double result = UnaryOperations.performUnaryOperation(a, operation);
		mainStack.push(result);
	}

	private void handleBinaryOperation(String operation) {
		Double a = mainStack.pop();
		Double b = mainStack.pop();
		Double result = BinaryOperations.performBinaryOperation(a, operation, b);
		mainStack.push(result);
	}

	private void handleSpecialOperation(String operation) {
		if (operation.equals("UNDO")) {
			Double x = mainStack.pop();
			undoStack.push(x);
		} else if (operation.equals("REDO")) {
			Double x = undoStack.pop();
			mainStack.push(x);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		UndoCalculator calculator = new UndoCalculator();
		String input = scan.next();

		while (input != "EXIT") {
			if (input.equals("RETURN")) { 
				System.out.println(Arrays.toString(calculator.mainStack.toArray())); 
				break;
			} // guard clause
			try {
				Double a = Double.parseDouble(input);
				calculator.mainStack.push(a);
			} catch (Exception e) {
				if (Arrays.asList(calculator.binary_operations).contains(input)) {
					calculator.handleBinaryOperation(input);
				} else if (Arrays.asList(calculator.unary_operations).contains(input)) {
					calculator.handleUnaryOperation(input);
				} else if (Arrays.asList(calculator.special_operations).contains(input)) {
					calculator.handleSpecialOperation(input);
				} else {
					System.out.println("That's not a valid operation.");
				}
			}
			input = scan.next();
		} 
		scan.close();
	}

}
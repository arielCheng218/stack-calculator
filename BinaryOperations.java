
public class BinaryOperations {

	private static int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); }

	private static int lcm(int a, int b) { return a * (b / gcd(a, b)); }
	
	public static double performBinaryOperation(double a, String operation, double b) {
		switch (operation) {
			case "+":
				return a + b;
			case "-":
				return a - b;
			case "*":
				return a * b;
			case "/":
				return a / b;
			case "%":
				return a % b;
			case "**":
				return Math.pow(a, b);
			case "gcd":
				int A = (int)Math.round(a);
				int B = (int)Math.round(b);
				return gcd(A, B);
			case "lcm":
				A = (int)Math.round(a);
				B = (int)Math.round(b);
				return lcm(A, B);
			case "|":
				return Math.round(a) | Math.round(b);
			case "&":
				return Math.round(a) & Math.round(b);
			case "^":
				return Math.round(a) ^ Math.round(b);
			case default:
				return 0.0;
		}
	}

}


public class UnaryOperations {

	public static Double performUnaryOperation(Double num, String operation) {
		switch (operation) {
			case "||":
				return Math.abs(num);
			case "√":
				return Math.sqrt(num);
			case "++":
				return num + 1;
			case "--":
				return num - 1;
			case "sin":
				return Math.sin(num);
			case "cos":
				return Math.cos(num);
			case "tan":
				return Math.tan(num);
			case "sec":
				return 1 / Math.cos(num);
			case "csc":
				return 1 / Math.sin(num);
			case "cot":
				return 1 / Math.tan(num);
			case default:
				return 0.0;
		}
	}

}
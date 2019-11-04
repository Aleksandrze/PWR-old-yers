

public class RPN {

	private static boolean isDelimeter(char c) {
		if ((" =".indexOf(c) != -1))
			return true;
		return false;
	}

	private static boolean isOperator(char c) {
		if (("+-/*^()".indexOf(c) != -1))
			return true;
		return false;
	}

	public static double calculate(String input) {
		double result = 0;
		StosTablicowyNP<Double> temp = new StosTablicowyNP<Double>();

		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i))) {
				String a = "";

				while (!isDelimeter(input.charAt(i)) && !isOperator(input.charAt(i))) {
					a += input.charAt(i);
					i++;
					if (i == input.length())
						break;
				}
				temp.push(Double.parseDouble(a));
				i--;
			} else if (isOperator(input.charAt(i))) {
				double a = temp.pop();
				double b = temp.pop();

				switch (input.charAt(i)) {
				case '+':
					result = b + a;
					break;
				case '-':
					result = b - a;
					break;
				case '*':
					result = b * a;
					break;
				case '/':
					result = b / a;
					break;
				case '^':
					result = (double) Math.pow(b, a);
					break;
				}
				temp.push(result);
			}
		}
		return temp.top();
	}
}

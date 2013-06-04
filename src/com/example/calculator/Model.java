package com.example.calculator;

public class Model {
	private int operand, res;
	private char op;
	public Model() {
		res = 0;
	}
	public void calculate(char temp) {
		switch(temp) {
			case '!':
				operand = 0;
				res = 0;
				break;
			case '+':
				;
			case '-':
				;
			case '*':
				;
			case '/':
				op = temp;
				operand = res;
				res = 0;
				break;
			case '=':
				switch(op) {
					case '+':
						res += operand;
						break;
					case '-':
						res -= operand;
						break;
					case '*':
						res += operand;
						break;
					case '/':
						res /= operand;
						break;
				}
				break;
		}
	}
	public String showResult() {
		return ((Integer)res).toString();
	}
}

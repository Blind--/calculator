package com.example.calculator;

public class Model {
	private int mOper, res;
	private char op;
	public Model() {
		res = 0;
	}
	public void setOperator(char ch) {
		op = ch;
	}
	public void setOperand(int oper) {
		mOper = oper;
	}
	
	public void calculate(int operand) {
		switch(op) {
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
				res = operand;
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
		return res + "";
	}
}

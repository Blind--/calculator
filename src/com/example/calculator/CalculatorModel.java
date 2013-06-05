package com.example.calculator;

public class CalculatorModel {
	private int mOperand, res;
	private char mOperator;
	public CalculatorModel() {
		res = 0;
	}
	public void setOperand(int i) {
		mOperand = i;
	}
	public void setOperator(char operator) {
		mOperator = operator;
	}
	public void calculate() {
		switch(mOperator) {
		case '+':
			res += mOperand;
			break;
		case '-':
			res -= mOperand;
			break;
		case '*':
			res *= mOperand;
			break;
		}
	}
	public String showResult() {
		return res + "";
	}
}

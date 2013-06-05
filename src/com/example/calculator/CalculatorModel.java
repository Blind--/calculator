package com.example.calculator;

public class CalculatorModel {
	private int mOperand, res;
	private char mOperator;
	public CalculatorModel() {
		res = 0;
	}
	public void setOperand(int i) {
		mOperand = mOperand*10 + i;
	}
	public void setOperator(char operator) {
		mOperator = operator;
	}
	public void calculate(int operand) {
		switch(mOperator) {
		case '+':
			res = mOperand + operand;
			break;
		case '-':
			res = mOperand - operand;
			break;
		case '*':
			res = mOperand * operand;
			break;
		}
	}
	public String showResult() {
		return res + "";
	}
}

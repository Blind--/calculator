package com.example.calculator;

import android.util.Log;

public class CalculatorModel {
	private int mOperand, res;
	private char mOperator;
	public CalculatorModel() {
		res = 0;
	}
	public void setOperand(int operand) {
		mOperand = operand;
	}
	public void setOperator(char operator) {
		mOperator = operator;
	}
	public void calculate(int operand) {
		Log.d("debug", "operand in model: " + mOperand + "\t operand in model: " + operand);
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
	@Override
	public String toString() {
		return res + "";
	}
}

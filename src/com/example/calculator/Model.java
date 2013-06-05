package com.example.calculator;

import android.util.Log;

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
		Log.d("debug", "value of mOper: " + mOper + "\t value of operand: " + operand);
		switch(op) {
			case '!':
				operand = 0;
				res = 0;
				break;
			case '+':
				res = mOper + operand;
				break;
			case '-':
				res = mOper - operand;
				break;
			case '*':
				res = mOper * operand;
				break;
		}
	}
	public String showResult() {
		return res + "";
	}
}

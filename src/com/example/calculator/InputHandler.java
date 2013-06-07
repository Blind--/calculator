package com.example.calculator;

import java.util.Stack;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InputHandler implements OnClickListener{
	private EditText mText;
	private CalculatorModel mMod;
	private Stack<String> hist;
	private char mOp;
	
	public InputHandler(EditText e, CalculatorModel m) {
		mText = e;
		mMod = m;
		hist = new Stack<String>();
	}
	//Overload1 : View
	private String getString(View v) {
		return ((Button)v).getText().toString();
	}
	//Overload2 : EditText
	private String getString(EditText e) {
		return e.getText().toString();
	}
	private int getCurrVal() {
		return Integer.parseInt(getString(mText));
	}
	public boolean isInteger(String str) {
		try { 
			Integer.parseInt(str); 
		} catch(NumberFormatException e) { 
			return false; 
		}
		return true;
	}
	private void updateBACK() {
		CharSequence display = mText.getText();
		mText.setText(display.subSequence(0, display.length()-1));
	}
	private void updateCLEAR() {
		mText.setText("");
	}
	private void updateOperation() {
		mMod.setOperator(mOp);
		Log.d("debug", "operator in control: " + mOp);
	}
	private void processInput(int id) {
		if (id == R.id.buttonBACK) {
			updateBACK();
			return;
		}
		switch(id) {
		case R.id.buttonMULTIPLY:
			mOp = '*';
			break;
		case R.id.buttonADD:
			mOp = '+';
			break;
		case R.id.buttonMINUS:
			mOp = '-';
			break;
		case R.id.buttonEQUALS:
			updateCLEAR();
			updateDisplay();
		}
		updateOperation();
	}	
	private void updateDisplay() {
		mMod.calculate(Integer.parseInt(hist.peek()));
		mText.setText(mMod.toString());
	}
	
	@Override
	public void onClick(View v) {
		if(isInteger(getString(v))) {
			if (!hist.empty() && !hist.peek().equals(null))//error1
				updateCLEAR();
			mText.append(getString(v));
			hist.push(getString(v));//error2
		} else {			
			//deal with non-operation buttons
			mMod.setOperand(getCurrVal());
			processInput(v.getId());
		}
	}
}

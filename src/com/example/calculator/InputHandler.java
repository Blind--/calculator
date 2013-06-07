package com.example.calculator;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InputHandler implements OnClickListener{
	private EditText mText;
	private CalculatorModel mMod;
	private char mOp;
	
	public InputHandler(EditText e, CalculatorModel m) {
		mText = e;
		mMod = m;
	}
	private String getString(View v) {
		return ((Button)v).getText().toString();
	}
	private String getString(EditText e) {
		return e.getText().toString();
	}
	private int getStringVal(String str) {
		return Integer.parseInt(str);
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
		mMod.setOperand(mOp);
	}
	private void processInput(int id) {
		if (id == R.id.buttonBACK) {
			updateBACK();
			return;
		}
		updateCLEAR();
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
			updateDisplay();
		}
		updateOperation();
	}	
	private void updateDisplay() {
		mMod.calculate(getStringVal(getString(mText)));
		mText.setText(mMod.toString());
	}
	@Override
	public void onClick(View v) {
		if(isInteger(getString(v))) {
			mText.append(getString(v));
		} else {			
			//needs to deal with Back and Clear (they are not operations)
			int val = getStringVal(getString(mText));
			mMod.setOperand(val);
			processInput(v.getId());
		}
	}
}

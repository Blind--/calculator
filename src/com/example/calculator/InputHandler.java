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
	private int getTextVal(String str) {
		return Integer.parseInt(str);
	}
	private void updateNum(int digit, int temp) {
		mText.append(digit+"");
		mMod.setOperand(temp*10+digit);
	}
	private void updateOperation(int id) {
		CharSequence display = mText.getText();
		if (id == R.id.buttonBACK) {
			mText.setText(display.subSequence(0, display.length()-1));
			return;
		}
		mText.setText("");
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
		}
		mMod.setOperand(mOp);
		mText.setText(mMod.showResult());
	}
	public boolean isInteger(String str) {
		try { 
			Integer.parseInt(str); 
		} catch(NumberFormatException e) { 
			return false; 
		}
		return true;
	}
	@Override
	public void onClick(View v) {
		int val = 0;
		if(isInteger(getString(v))) {
			val = getTextVal(getString(mText));
			updateNum(getTextVal(getString(v)),val);
		} else {			
			updateOperation(v.getId());
			mMod.calculate(val);
		}
	}
}

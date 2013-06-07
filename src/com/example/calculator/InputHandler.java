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
	private char mOp;
	
	public InputHandler(EditText e, CalculatorModel m) {
		mText = e;
		mMod = m;
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
		//mText.setText(hist.peep());
		CharSequence display = mText.getText();
		mText.setText(display.subSequence(0, display.length()-1));
	}
	private void updateCLEAR() {
		mText.setText("");
	}
	private void updateOperation() {
		mMod.setOperator(mOp);
	}
	private void processInput(int id) {
		switch(id) {
		case R.id.buttonBACK:
			updateBACK();
			return;
		case R.id.buttonCLEAR:
			updateCLEAR();
			break;
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
		mMod.setOperand(getCurrVal());
		updateOperation();
	}	
	private void updateDisplay() {
		mMod.calculate(getCurrVal());
		mText.setText(mMod.toString());
	}
	private boolean mClearText;
	@Override
	public void onClick(View v) {
		if(isInteger(getString(v))) {
			if(mClearText) {
				updateCLEAR();
				mClearText = false;
			}
			mText.append(getString(v));
		} else {		
			if(v.getId() == R.id.buttonEQUALS) {
				updateDisplay();
			} else {
				mMod.setOperand(getCurrVal());
				processInput(v.getId());	// store operator and deal with clr,back
				mClearText = true;
			}
		}
	}
}

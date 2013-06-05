package com.example.calculator;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InputHandler implements OnClickListener{
	private EditText mText;
	private CalculatorModel mMod;
	private CharSequence display;
	
	public InputHandler(EditText e, CalculatorModel m) {
		mText = e;
		mMod = m;
		display = mText.getText();
	}
	private String getButtonText(View v) {
		return ((Button)v).getText().toString();
	}
	private int getTextVal(String str) {
		return Integer.parseInt(str);
	}
	private void updateNum(int digit, int temp) {
		mText.append(digit+"");
		mMod.setOperand(temp*10+digit);
	}
	private void updateOperation(int id) {
		if (id == R.id.buttonBACK) {
			mText.setText(display.subSequence(0, display.length()-1));
			return;
		}
		mText.setText("");
		switch(id) {
		case R.id.buttonMULTIPLY:
			mMod.setOperand(id);
			break;
		case R.id.buttonADD:
			mMod.setOperand(id);
			break;
		case R.id.buttonMINUS:
			mMod.setOperand(id);
			break;
		}
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
		if(isInteger(getButtonText(v))) {
			int val = getTextVal(display.toString());
			updateNum(getTextVal(getButtonText(v)),val);
		} else {			
			updateOperation(v.getId());
			mMod.calculate();
		}
	}
	
}

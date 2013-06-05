package com.example.calculator;
//import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Controller implements OnClickListener{
	private EditText mText;
	private boolean mClearText;
	private Model mMod;
	private int curr;
	public Controller(EditText text, Model mod) {
		mText = text;
		mMod = mod;
	}
	public boolean isInteger(String str) {
		try { 
			Integer.parseInt(str); 
		} catch(NumberFormatException e) { 
			return false; 
		}
		return true;
	}
	public void updateDisplay() {
		mText.setText("");
		mMod.calculate(curr);
		mText.setText(mMod.showResult());
		//	Log.d("debug", "current value: " + curr + "\t result: " + mMod.showResult());
	}
	public void checkOperator(int id) {
		switch(id) {
		case R.id.buttonCLEAR:
			mMod.setOperator('!');
			mText.setText("");
			break;    		
		case R.id.buttonBACK:
			mText.setText((curr-curr%10)/10);
		case R.id.buttonADD:
			mMod.setOperator('+');
			break;
		case R.id.buttonMINUS:
			mMod.setOperator('-');
			break;
		case R.id.buttonMULTIPLY:
			mMod.setOperator('*');
			break;
		case R.id.buttonEQUALS:
			curr = getTextNum(mText);
			updateDisplay();
		}
		mMod.setOperand(curr);
	}
	private int getTextNum(EditText e) {
		return Integer.parseInt(mText.getText().toString());
	}
	private CharSequence getText(Button b) {
		return b.getText().toString();
	}
	@Override
	public void onClick(View v) {
		CharSequence ch = getText((Button)v);
		if (isInteger(ch.toString())) {
			if(mClearText) {
				mText.setText("");
				mClearText = false;
			}
			mText.append(ch);
		} else {
			checkOperator(v.getId());
			mClearText = true;
		}
	}
}
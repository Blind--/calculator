package com.example.calculator;
import android.util.Log;
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
	@Override
	public void onClick(View v) {
		CharSequence ch = ((Button)v).getText().toString();
		if (isInteger(ch.toString())) {
			if(mClearText) {
				mText.setText("");
				mClearText = false;
			}
			mText.append(ch);
		} else {
			if (v.getId() == R.id.buttonEQUALS) {
				curr = Integer.parseInt(mText.getText().toString());
				updateDisplay();
			} else {
				//			Log.d("debug", "text is: "+ mText.getText().toString());
				curr = Integer.parseInt(mText.getText().toString());
				mMod.setOperand(curr);
				switch(v.getId()) {
				case R.id.buttonClear:
					mMod.setOperator('!');
					mText.setText("");
					break;    		     
				case R.id.buttonADD:
					mMod.setOperator('+');
					break;
				case R.id.buttonMINUS:
					mMod.setOperator('-');
					break;
				case R.id.buttonMULTIPLY:
					mMod.setOperator('*');
					break;
				}
				mClearText = true;
			}
		}
	}
}
package com.example.calculator;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText text;
	private Model model;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		text = (EditText)findViewById(R.id.Row1_ShowInput);
		model = new Model();

		final int[] ids = {R.id.button0,R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,
				R.id.button6,R.id.button7,R.id.button8,R.id.button9,
				R.id.buttonADD,R.id.buttonMINUS,R.id.buttonMULTIPLY,R.id.buttonCLEAR,R.id.buttonEQUALS,R.id.buttonBACK};
		final Button[] num = new Button[ids.length];

		Controller controller = new Controller(text, model);
		for (int i = 0; i < num.length; i++) {
			num[i] = (Button)findViewById(ids[i]);
			num[i].setOnClickListener(controller);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
